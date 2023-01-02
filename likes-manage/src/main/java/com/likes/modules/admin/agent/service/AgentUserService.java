package com.likes.modules.admin.agent.service;

import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.request.AgentUsersRequest;
import com.likes.common.model.request.SysAgentinfoReq;
import com.likes.common.mybatis.entity.AgentUser;
import com.likes.common.service.BaseService;

/**
 * @author 阿布
 */
public interface AgentUserService extends BaseService {

    boolean addAgentUser(AgentUser agentUser);

    boolean editAgentUser(AgentUser agentUser);
}