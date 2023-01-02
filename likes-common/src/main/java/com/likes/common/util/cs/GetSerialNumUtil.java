package com.likes.common.util.cs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class GetSerialNumUtil {

    /**记录已有流水单*/
    public static int num = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static String getNum() {
        String unique = "";

        //上锁
        lock.lock();
        try {

            //------------------流水号业务逻辑----------------

            //5位流水号
            if (num == 0) {
                //当天第一份流水单号
                unique = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "01";
            } else {
                //当天最后的订单流水号累加1
                String nums = String.valueOf(num + 1);

                //设定具体流水为两位数，单数则补齐前面的0
                StringBuilder sb = new StringBuilder(nums);
                for (int i = nums.length(); i < 2; i++) {
                    sb.insert(0, "0");
                }
                unique = new SimpleDateFormat("yyyyMMdd").format(new Date()) + sb.toString();
            }

            //已有流水单+1
            num++;

            //----------------------------------

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }

        return unique;
    }
}
