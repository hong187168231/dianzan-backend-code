package com.likes.modules.admin.users.service.impl;

import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.AgentUserMapper;
import com.likes.common.service.BaseServiceImpl;
import com.likes.modules.admin.users.service.AgentUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author abu
 * @version 1.0
 * @Description
 * @revise
 * @time 2018年6月8日 下午3:24:55
 */
@Service
public class AgentUserServiceImpl extends BaseServiceImpl implements AgentUserService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AgentUserMapper agentUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AgentUser queryAgentSerurl(String acct) {
        AgentUser agentUserParam = new AgentUser();
        agentUserParam.setAccno(acct);
        AgentUser agentUser = agentUserMapper.selectOne(agentUserParam);
        return agentUser;
    }

}