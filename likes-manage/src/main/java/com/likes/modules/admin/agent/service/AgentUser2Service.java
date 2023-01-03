package com.likes.modules.admin.agent.service;

import com.likes.common.mybatis.entity.AgentUser;
import com.likes.common.service.BaseService;

/**
 * @author 阿布
 */
public interface AgentUser2Service extends BaseService {

    boolean addAgentUser(AgentUser agentUser);

    boolean editAgentUser(AgentUser agentUser);
}