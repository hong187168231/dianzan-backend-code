package com.likes.modules.admin.job;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.likes.common.annotation.ReadOnlyConnection;
import com.likes.common.model.dto.RankDto;
import com.likes.common.mybatis.entity.MemGoldchange;
import com.likes.common.mybatis.mapper.MemGoldchangeMapper;
import com.likes.common.mybatis.mapper.MemLevelMapper;
import com.likes.common.mybatis.mapper.TaskOrderMapper;
import com.likes.common.mybatis.mapper.UserMapper;
import com.likes.common.mybatis.mapperext.member.MemLevelMapperExt;
import com.likes.common.util.CollectionUtil;
import com.likes.common.util.DateUtils;
import com.likes.common.util.IdGeneratorUtil;
import com.likes.common.util.StringUtils;
import com.likes.common.util.redis.RedisBaseUtil;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class TestTask {

    @Resource
    private TaskOrderMapper taskOrderMapper;
    @Resource
    private MemLevelMapperExt memLevelMapperExt;
    @Resource
    private MemGoldchangeMapper memGoldchangeMapper;
    @Autowired
    IdGeneratorUtil idGeneratorUtil;
    @Resource
    private RedisBaseUtil redisUtil;

    Logger log = LoggerFactory.getLogger(TestTask.class);

    @Scheduled(fixedDelay = 5000)
    public void repairGameRecordJob() throws InterruptedException {
        log.info("定时器开始拉取OB真人注单记录");
        String startTime = (String) redisUtil.get("OBZR:repair:startTime");
        String endTime = (String) redisUtil.get("OBZR:repair:endTime");
        if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
            System.out.println(111);
        }
        log.info("定时器补取OB真人注单记录");
    }



}
