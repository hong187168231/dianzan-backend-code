package com.likes.common.util.redis;

import com.likes.common.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * redis 分布式锁，全局排他锁
 */
public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    private final RedisTemplate redisTemplate;

    public static final int TIMEOUT_ONE_HUNDRED_MSECS = 100 * 1000;

    public static final int TIMEOUT_ONE_SECOND_MSECS = 60 * 1000;

    /** 生成随机码超时时间 */
    public static final int TIMEOUT_ONE_SYSRANDOM_MSECS = 30 * 60 * 1000;
    /** 重试时间 */
    private static final int DEFAULT_ACQUIRY_RETRY_MILLIS = 100;
    /** 默认过期时间：10秒 */
    private static final int DEFAULT_EXPIRE_MILLIS = 20000;
    /** controller入口层的请求控制，2秒内不允许重复请求 */
    private static final int REQUEST_TIMEOUT_MILLIS = 2000;
    /** 锁的后缀 */
    private static final String LOCK_SUFFIX = "_REDIS_LOCK";
    /** 锁的key */
    private final String lockKey;
    /** 锁超时时间，防止线程在入锁以后，防止阻塞后面的线程无法获取锁 */
    private int expireMsecs = DEFAULT_EXPIRE_MILLIS;
    /** 线程获取锁的等待时间 */
    private int timeoutMsecs = 1 * 1000;
    /** 线程持有锁的间隔时间，默认2秒 */
    private int holdMsecs = 2 * 1000;
    /** 是否锁定标志 */
    private volatile boolean locked = false;
    /** 获取到锁的时间 */
    private long lockedTime = System.currentTimeMillis();
    //账变余额修改前缀
    public static final String UPDATE_USER_BALANCE_ = "UPDATE_USER_BALANCE_";

    // 财务 APP 充值 申请
    public static final String FINANCE_APP_PAY_APPLY = "FINANCE_APP_PAY_APPLY_";
    public static final String FINANCE_APP_PAY_APPLY_LOCK = "FINANCE_APP_PAY_APPLY_LOCK_";
    // 财务 APP 提现 申请
    public static final String FINANCE_APP_WITHDRAWAL_APPLY_LOCK = "FINANCE_APP_WITHDRAWAL_APPLY_LOCK_";
    public static final String FINANCE_APP_WITHDRAWAL_APPLY = "FINANCE_APP_WITHDRAWAL_APPLY_";

    public static final String FINANCE_APP_USDT_APPLY_LOCK = "FINANCE_APP_USDT__APPLY_LOCK_";

    public static final String FINANCE_APP_YUEBAO_APPLY = "FINANCE_YUEBAO_APPLY_";

    public static final String FINANCE_APP_ASSET_APPLY = "FINANCE_APP_ASSET_APPLY";
    public static final String FINANCE_APP_WITHDRAWAL_UDUN = "FINANCE_APP_WITHDRAWAL_UDUN_";
    public static final String FINANCE_APP_SUBMITTASK_APPLY_LOCK = "FINANCE_APP_SUBMITTASK_APPLY_LOCK";

    public static final String FINANCE_APP_SUBMITBANK_APPLY_LOCK = "FINANCE_APP_SUBMITBANK_APPLY_LOCK";
    public static final String FINANCE_APP_GET_LOCK = "FINANCE_APP_GET_LOCK";
    public static final String FINANCE_APP_BUY_LOCK = "FINANCE_APP_BUY_LOCK";
    public static final String RECEIVE_APP_TASK_APPLY = "RECEIVE_APP_TASK_APPLY";

    // 财务 MANAGE 充值 确认
    public static final String FINANCE_MANAGE_PAY_CONFIRM = "FINANCE_MANAGE_PAY_CONFIRM_";
    // 财务 MANAGE 提现 处理
    public static final String FINANCE_MANAGE_WITHDRAWAL_SURE = "FINANCE_MANAGE_WITHDRAWAL_SURE_";
    // 财务 MANAGE 提现 取消
    public static final String FINANCE_MANAGE_WITHDRAWAL_CANCEL = "FINANCE_MANAGE_WITHDRAWAL_CANCEL_";
    // 财务 MANAGE 提现 确认
    public static final String FINANCE_MANAGE_WITHDRAWAL_CONFIRM = "FINANCE_MANAGE_WITHDRAWAL_CONFIRM_";
    // 财务 MANAGE 手动调整金额
    public static final String FINANCE_MANAGE_BALANCE_ADJUSTMENT = "FINANCE_MANAGE_BALANCE_ADJUSTMENT_";
    // 财务 MANAGE 批量手动调整金额
    public static final String FINANCE_MANAGE_BATCH_BALANCE_ADJUSTMENT = "FINANCE_MANAGE_BATCH_BALANCE_ADJUSTMENT_";
    // 财务 MANAGE 手动调整金额
    public static final String FINANCE_MANAGE_DAMALIANG_ADJUSTMENT = "FINANCE_MANAGE_DAMALIANG_ADJUSTMENT_";
    // 财务 MANAGE 批量手动调整金额
    public static final String FINANCE_MANAGE_BATCH_DAMALIANG_ADJUSTMENT = "FINANCE_MANAGE_BATCH_DAMALIANG_ADJUSTMENT_";
    // 财务 MANAGE 手动调整金额
    public static final String FINANCE_MANAGE_BALANCE_ADJACKPOT_ = "FINANCE_MANAGE_BALANCE_ADJACKPOT_";

    /**
     * 带请求时间间隔的2秒的请求唯一锁，一般用于controller入口层的请求控制
     *
     * @param lockKey
     * @return
     */
    public static RedisLock newRequestLock(String lockKey) {
        return newRequestLock(lockKey, REQUEST_TIMEOUT_MILLIS);
    }

    /**
     * @Title: newSpecialRequire
     * @Description: 按照业务要求时间，配置锁时间
     * @author HANS
     * @date 2019年10月21日下午7:28:55
     */
    public static RedisLock newSpecialRequire(String lockKey, int time) {
        return newRequestLock(lockKey, time);
    }

    /**
     * controller入口层的请求控制，2秒内不允许重复请求
     * 需配合 unlockWhenHoldTime 使用生效，当 holdMsecs 设置为0时，unlockWhenHoldTime 和 unlock 效果相同
     *
     * @param lockKey   锁-key
     * @param holdMsecs 锁保持时间，实际表现为每个请求的间隔时间
     * @return
     */
    public static RedisLock newRequestLock(String lockKey, int holdMsecs) {
        RedisLock redisLock = new RedisLock(lockKey, 0);
        holdMsecs = (holdMsecs <= 0 ? REQUEST_TIMEOUT_MILLIS : holdMsecs);
        redisLock.holdMsecs = holdMsecs;
        return redisLock;
    }

    /**
     * 构造器
     *
     * @param lockKey 锁的key
     */
    public RedisLock(String lockKey) {
        this.redisTemplate = (RedisTemplate) SpringUtil.getBean("redisTemplate");
        this.lockKey = lockKey + LOCK_SUFFIX;
    }

    /**
     * 构造器
     *
     * @param lockKey      锁的key
     * @param timeoutMsecs 获取锁的超时时间
     */
    public RedisLock(String lockKey, int timeoutMsecs) {
        this(lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }

    /**
     * 构造器
     *
     * @param lockKey      锁的key
     * @param timeoutMsecs 获取锁的超时时间
     * @param expireMsecs  锁的有效期
     */
    public RedisLock(String lockKey, int timeoutMsecs, int expireMsecs) {
        this(lockKey, timeoutMsecs);
        this.expireMsecs = expireMsecs <= 0 ? DEFAULT_EXPIRE_MILLIS : expireMsecs;
    }

    public String getLockKey() {
        return lockKey;
    }

    /**
     * 封装和jedis方法
     *
     * @param key
     * @return
     */
    private String get(final String key) {
        Object obj = redisTemplate.opsForValue().get(key);
        return obj != null ? obj.toString() : null;
    }

    /**
     * 封装和jedis方法
     *
     * @param key
     * @param value
     * @return
     */
    private boolean setNX(final String key, final String value) {
        boolean result = false;
        try {
            result = redisTemplate.opsForValue().setIfAbsent(key, value, expireMsecs, TimeUnit.MICROSECONDS);
            logger.info("redis lock by key:{} time:{} success", key, expireMsecs);
        } catch (Exception e) {
            logger.error("expire key:{} time:{} occur error.", key, this.expireMsecs);
        }
        return result;
    }

    /**
     * 封装和jedis方法
     *
     * @param key
     * @param value
     * @return
     */
    private String getSet(final String key, final String value) {
        Object obj = redisTemplate.opsForValue().getAndSet(key, value);
        return obj != null ? (String) obj : null;
    }

    /**
     * 获取锁
     *
     * @return 获取锁成功返回ture，超时返回false
     * @throws InterruptedException
     */
    public synchronized boolean lock() throws InterruptedException {
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + expireMsecs + 1;
            // 锁到期时间
            String expiresStr = String.valueOf(expires);
            if (this.setNX(lockKey, expiresStr)) {
                locked = true;
                this.lockedTime = System.currentTimeMillis();
                return true;
            }
            // redis里key的时间
            String currentValue = this.get(lockKey);
            // 判断锁是否已经过期，过期则重新设置并获取
            if (currentValue != null && Long.parseLong(currentValue) < System.currentTimeMillis()) {
                // 设置锁并返回旧值
                String oldValue = this.getSet(lockKey, expiresStr);
                // 比较锁的时间，如果不一致则可能是其他锁已经修改了值并获取
                if (oldValue != null && oldValue.equals(currentValue)) {
                    locked = true;
                    this.lockedTime = System.currentTimeMillis();
                    return true;
                }
            }
            timeout -= DEFAULT_ACQUIRY_RETRY_MILLIS;
            // 延时
            Thread.sleep(DEFAULT_ACQUIRY_RETRY_MILLIS);
        }
        return false;
    }

    /**
     * 释放获取到的锁
     * 业务处理完及时释放
     */
    public synchronized void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            logger.info("redis lock unlock:{} success.", lockKey);
            locked = false;
        }
    }

    /**
     * <pre>
     * 释放获取到的锁
     *   该锁释放的场景：请求必须保持指定时间间隔才释放，一般配合 newRequestLock 实现请求的全局唯一及时间间隔。如一个请求间隔 2秒。
     *   与unlockWhenTimeout的区别：
     *      unlockWhenTimeout 也是要程序保持 timeout 时间才释放锁，但 timeout 时间内多个线程仍可获取锁，其作用的场景一般用于任务队列
     *      unlockWhenHoldTime 是配合 newRequestLock 使用，实现请求的全局唯一，其 timeout 固定为0，同一时间只有一个节点获取到锁
     *      其次是据 holdMsecs 实现请求的时间间隔。
     * </pre>
     */
    public synchronized void unlockWhenHoldTime() {
        if (locked) {
            long current = System.currentTimeMillis();
            long times = current - 1 - this.lockedTime - this.holdMsecs;
            if (times < 0) {
                //等待获取锁超时
                try {
                    Thread.sleep(Math.abs(times));
                } catch (InterruptedException e) {
                    logger.error("unlockWhenHoldTime occur error.", e);
                }
            }
            redisTemplate.delete(lockKey);
            logger.info("redis lock unlockWhenHoldTime:{} success.", lockKey);
            locked = false;
        }
    }

    public synchronized void unlockByHoldTime(long holdTime) {
        if (locked && holdTime > 0) {
            //等待获取锁超时
            try {
                Thread.sleep(Math.abs(holdTime));
            } catch (InterruptedException e) {
                logger.error("unlockByHoldTime:{} holdTime:{} occur error.", lockKey, holdTime, e);
            }
            redisTemplate.delete(lockKey);
            logger.info("redis lock unlockByHoldTime:{} holdTime:{} success.", lockKey, holdTime);
            locked = false;
        }
    }

    /**
     * <pre>
     * 释放获取到的锁
     * 等到获取锁时间超时后释放，该方法主要用于控制任务队列场景
     * 此方法不推荐使用，其使用场景显得模糊，在使用 timeout 的场景一般是控制分布式队列，而队列每个任务又要等到其超时后才释放锁，
     * 这可能会导致多个任务节点最终只会有一个节点执行，其对应的队列控制场景释放锁应使用 unlock 及时释放。
     * </pre>
     */
    public synchronized void unlockWhenTimeout() {
        if (locked) {
            long current = System.currentTimeMillis();
            long times = current - 1 - this.lockedTime - this.timeoutMsecs;
            if (times < 0) {
                //等待获取锁超时
                try {
                    Thread.sleep(Math.abs(times));
                } catch (InterruptedException e) {
                    logger.error("unlockWhenTimeout occur error.", e);
                }
            }
            redisTemplate.delete(lockKey);
            logger.info("redis lock unlockWhenTimeout:{} success.", lockKey);
            locked = false;
        }
    }


    /**
     * 等待过期时删除 redis key
     * 此方法一般应用在耗时较久或批量定时任务场景
     */
    public synchronized void unlockWhenExpired() {
        if (locked) {
            long current = System.currentTimeMillis();
            long times = current - 1 - this.lockedTime - this.expireMsecs;
            if (times < 0) {
                try {
                    Thread.sleep(Math.abs(times));
                } catch (InterruptedException e) {
                    logger.error("unlockWhenExpired sleep occur error,key:{}.", this.lockKey, e);
                }
            }
            redisTemplate.delete(lockKey);
            logger.info("redis lock unlockWhenExpired key:{}, expireTime:{} ms success.", lockKey, this.expireMsecs);
            locked = false;
        }
    }

}