package com.likes.modules.admin.agent.service.impl;

import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.AgentUserMapper;
import com.likes.common.service.BaseServiceImpl;
import com.likes.modules.admin.agent.service.AgentUser2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 阿布
 */

@Service
public class Agent2UserServiceImpl extends BaseServiceImpl implements AgentUser2Service {

    @Resource
    private AgentUserMapper agentUserMapper;


    @Override
    public boolean addAgentUser(AgentUser agentUser) {
        return agentUserMapper.insertSelective(agentUser) > 0;
    }

    @Override
    public boolean editAgentUser(AgentUser agentUser) {
        return agentUserMapper.updateByPrimaryKeySelective(agentUser) > 0;
    }
}