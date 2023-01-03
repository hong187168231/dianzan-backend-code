package com.likes.modules.admin.user.service;


import com.likes.common.model.AgentUserDetailDO;
import com.likes.common.model.AgentUserQuery;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.request.AgentUserRequest;

public interface AgentUserService {

    boolean createUser(AgentUserRequest request, LoginUser loginUser);

    boolean updateUser(AgentUserRequest request, LoginUser loginUser);

    AgentUserDetailDO userDetail(Long repayMemId);

    PageResult userList(AgentUserQuery query, PageBounds page);
}