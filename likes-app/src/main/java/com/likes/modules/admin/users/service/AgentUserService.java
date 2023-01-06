package com.likes.modules.admin.users.service;

import com.likes.common.mybatis.entity.AgentUser;
import com.likes.common.service.BaseService;

import java.util.List;

/**
 * @author abu
 *
 */
public interface AgentUserService extends BaseService {
    public AgentUser queryAgentSerurl(String acct);

}