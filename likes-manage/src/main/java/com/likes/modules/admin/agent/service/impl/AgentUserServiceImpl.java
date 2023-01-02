package com.likes.modules.admin.agent.service.impl;

import com.likes.common.constant.Constants;
import com.likes.common.enums.LoginUserTypeEnum;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.request.AgentUsersRequest;
import com.likes.common.model.request.SysAgentinfoReq;
import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.AgentUserMapper;
import com.likes.common.mybatis.mapper.SysAgentinfoMapper;
import com.likes.common.mybatis.mapperext.sys.SysAgentinfoMapperExt;
import com.likes.common.service.BaseServiceImpl;
import com.likes.common.service.credit.MemCreditService;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.service.member.MemLevelService;
import com.likes.common.service.member.MemLoginService;
import com.likes.common.service.member.MemRelationshipService;
import com.likes.common.service.sys.SysBusParamService;
import com.likes.common.util.*;
import com.likes.modules.admin.agent.service.AgentService;
import com.likes.modules.admin.agent.service.AgentUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 阿布
 */

@Service
public class AgentUserServiceImpl extends BaseServiceImpl implements AgentUserService {

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