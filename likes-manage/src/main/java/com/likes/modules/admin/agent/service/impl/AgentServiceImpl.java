package com.likes.modules.admin.agent.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.likes.common.constant.Constants;
import com.likes.common.enums.LoginUserTypeEnum;
import com.likes.common.model.SysRecord;
import com.likes.common.model.request.AgentUsersEditRequest;
import com.likes.common.model.request.AgentUsersRequest;
import com.likes.common.model.request.UsersRequest;
import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.SysRecordMapper;
import com.likes.common.service.BaseServiceImpl;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.request.SysAgentinfoReq;
import com.likes.common.mybatis.mapper.SysAgentinfoMapper;
import com.likes.common.mybatis.mapperext.sys.SysAgentinfoMapperExt;
import com.likes.common.service.credit.MemCreditService;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.service.member.MemLevelService;
import com.likes.common.service.member.MemLoginService;
import com.likes.common.service.member.MemRelationshipService;
import com.likes.common.service.sys.SysBusParamService;
import com.likes.common.service.sys.SysRecordService;
import com.likes.common.util.*;
import com.likes.modules.admin.agent.service.AgentService;
import com.likes.modules.admin.agent.service.AgentUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 阿布
 */

@Service
public class AgentServiceImpl extends BaseServiceImpl implements AgentService {

    @Resource
    private SysAgentinfoMapper sysAgentinfoMapper;
    @Resource
    private SysAgentinfoMapperExt sysAgentinfoMapperExt;

    @Resource
    private MemLoginService memLoginService;

    @Resource
    private SysBusParamService sysBusParamService;

    @Resource
    private MemBaseinfoService memBaseinfoService;

    @Resource
    private MemCreditService memCreditService;

    @Resource
    private MemLevelService memLevelService;
    @Resource
    private AgentUserService agentUserService;

    @Resource
    private MemRelationshipService memRelationshipService;

    @Override
    public PageResult getList(SysAgentinfoReq req, PageBounds page) {
        return PageResult.getPageResult(page, this.sysAgentinfoMapperExt.getList(req, page.toRowBounds()));
    }


    @Override
    public void addAgent(AgentUsersRequest req, LoginUser user) throws BusinessException {
        if (StringUtils.isEmpty(req.getPassword())) {
            throw new BusinessException(StatusCode.LIVE_ERROR_126.getCode(), "密码为空");
        }
        MemLogin ml = memLoginService.findByEmailRegister(req.getEmail());
        if (ml != null) {
            throw new BusinessException(StatusCode.LIVE_ERROR_119.getCode(), "该邮箱已存在");
        }
        // 插入用户
        MemBaseinfo newUser = new MemBaseinfo();
        newUser.setNationality("china");
        newUser.setAccno(RandomUtil.uuid());
        newUser.setUniqueId(SnowFlakeUtil.getId().toString());
        newUser.setEmail(req.getEmail());
        String dateStr = DateUtils.currentTimeStr();
        newUser.setNickname(NameGeneratorUtil.generate() + dateStr.substring(dateStr.length() - 3));
        newUser.setFansnum(0L);
        newUser.setGoldnum(BigDecimal.ZERO);
        newUser.setRegisterdate(new Date());
        newUser.setIsDelete(false);
        newUser.setCreateUser(newUser.getAccno());
        newUser.setUpdateUser(newUser.getAccno());
        newUser.setRegisterDev("web");

        newUser.setLogintype(LoginUserTypeEnum.ORDINARY.getCode());
        newUser.setAgentLevel(1);
        newUser.setMemorgin(Constants.OPERATRA);
        newUser.setHeadimg(sysBusParamService.getRandomHeadImg());
        // 用户基本信息
        memBaseinfoService.insertSelective(newUser);
        // 设置注册用户的邀请码
        newUser.setRecomcode(InvitationCodeGnerateUtil.generateInvitationCodeTwo(newUser));
        memBaseinfoService.updateByPrimaryKeySelective(newUser);

        // 登陆用户
        MemLogin memLogin = new MemLogin();
        memLogin.setLoginnum(0);
        memLogin.setAcclogin(newUser.getEmail());
        memLogin.setAccno(newUser.getAccno());
        memLogin.setLogintype(LoginUserTypeEnum.ORDINARY.getCode());
        memLogin.setPasswordmd5(req.getPassword());
        memLogin.setAccstatus(Constants.ACCOUNT_ONE);
        int i = memLoginService.insertSelectiveMemLogin(memLogin);
        if (i == 0) {
            throw new BusinessException(StatusCode.LIVE_ERROR_119.getCode(), "该手机号已存在");
        }
        boolean flag = memCreditService.initMemberCredit(newUser.getAccno());
        if (!flag) {
            throw new BusinessException(StatusCode.LIVE_ERROR_1119.getCode(), "会员信用分初始化失败！");
        }
        asynRegister(req, newUser);
        AgentUser agentUser = new AgentUser();
        agentUser.setCreateTime(new Date());
        agentUser.setSingleAddMoney(req.getSingleAddMoney());
        agentUserService.addAgentUser(agentUser);
    }

    @Override
    public void editAgent(AgentUsersRequest req, LoginUser user) throws BusinessException {
        AgentUser agentUser = new AgentUser();
        agentUser.setCreateTime(new Date());
        agentUser.setSingleAddMoney(req.getSingleAddMoney());
        agentUserService.editAgentUser(agentUser);
    }


    private void asynRegister(AgentUsersRequest req, MemBaseinfo newUser) {
        // 建立推荐人关系
        inviteUserProcess(req, newUser);
        //初始化用户等级
        memLevelService.initMemLevel(newUser.getAccno());
    }


    /**
     * 根据邀请码进来的用户，建立推荐人关系
     *
     * @param req
     * @param newUser
     */
    private void inviteUserProcess(AgentUsersRequest req, MemBaseinfo newUser) {
        memBaseinfoService.updateSuperiorId(newUser.getAccno(), "0");
        // 插入推荐关系
        MemRelationship memRelationship = new MemRelationship();
        memRelationship.setRefaccno("root");
        memRelationship.setSuprecomcode("fff666");
        memRelationship.setAccno(newUser.getAccno());
        memRelationship.setCreateUser(newUser.getAccno());
        memRelationship.setUpdateUser(newUser.getAccno());
        memRelationship.setHeadAccno("root");
        memRelationship.setParentId(1L);
        memRelationship.setIsDelete(false);
        memRelationshipService.insertSelectiveMemRelationship(memRelationship);
    }




}