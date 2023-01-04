package com.likes.modules.admin.user.service.impl;


import com.github.pagehelper.PageHelper;
import com.likes.common.constant.Constants;
import com.likes.common.enums.LoginUserTypeEnum;
import com.likes.common.enums.StatusCode;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.AgentUserDetailDO;
import com.likes.common.model.AgentUserQuery;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.model.dto.AgentUserDO;
import com.likes.common.model.dto.member.MemLoginDO;
import com.likes.common.model.request.AgentUserRequest;
import com.likes.common.model.request.AgentUsersRequest;
import com.likes.common.mybatis.entity.*;
import com.likes.common.mybatis.mapper.AgentUserMapper;
import com.likes.common.mybatis.mapper.MemLoginMapper;
import com.likes.common.mybatis.mapper.MemRepayuserMapper;
import com.likes.common.mybatis.mapperext.member.MemLoginMapperExt;
import com.likes.common.service.code.UniqueCodeService;
import com.likes.common.service.credit.MemCreditService;
import com.likes.common.service.member.MemBaseinfoService;
import com.likes.common.service.member.MemLevelService;
import com.likes.common.service.member.MemLoginService;
import com.likes.common.service.member.MemRelationshipService;
import com.likes.common.service.sys.SysBusParamService;
import com.likes.common.util.*;
import com.likes.modules.admin.user.service.AgentUserService;
import com.github.pagehelper.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class AgentUserServiceImpl implements AgentUserService {


    @Resource
    private MemLoginService memLoginService;
    @Resource
    private MemRepayuserMapper memRepayuserMapper;
    @Resource
    private MemBaseinfoService memBaseinfoService;
    @Resource
    private SysBusParamService sysBusParamService;
    @Resource
    private MemCreditService memCreditService;
    @Resource
    private MemLevelService memLevelService;
    @Resource
    private MemRelationshipService memRelationshipService;
    @Resource
    private MemLoginMapper memLoginMapper;
    @Resource
    private MemLoginMapperExt memLoginMapperExt;
    @Resource
    private AgentUserMapper agentUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createUser(AgentUserRequest request, LoginUser loginUser) {
        // 检验参数
        this.validateParams(request);
        MemLogin ml = memLoginMapperExt.findByAccloginRegister(request.getEmail());
        if (ml != null) {
            throw new BusinessException(StatusCode.ACCOUNT_EMPTY.getCode(), "账号已存在");
        }
        // 插入用户
        MemBaseinfo newUser = new MemBaseinfo();
        newUser.setNationality("china");
        newUser.setAccno(RandomUtil.uuid());
        newUser.setUniqueId(SnowFlakeUtil.getId().toString());
        newUser.setEmail(request.getEmail());
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
        newUser.setRecomcode("px"+InvitationCodeGnerateUtil.generateInvitationCodeTwo(newUser));
        memBaseinfoService.updateByPrimaryKeySelective(newUser);

        // 登陆用户
        MemLogin memLogin = new MemLogin();
        memLogin.setLoginnum(0);
        memLogin.setAcclogin(newUser.getEmail());
        memLogin.setAccno(newUser.getAccno());
        memLogin.setLogintype(LoginUserTypeEnum.ORDINARY.getCode());
        memLogin.setPasswordmd5(request.getPassword());
        memLogin.setAccstatus(Constants.ACCOUNT_ONE);
        int i = memLoginService.insertSelectiveMemLogin(memLogin);
        if (i == 0) {
            throw new BusinessException(StatusCode.LIVE_ERROR_119.getCode(), "该手机号已存在");
        }
        boolean flag = memCreditService.initMemberCredit(newUser.getAccno());
        if (!flag) {
            throw new BusinessException(StatusCode.LIVE_ERROR_1119.getCode(), "会员信用分初始化失败！");
        }
        asynRegister(request, newUser);
        AgentUser agentUser = new AgentUser();
        agentUser.setAccno(newUser.getAccno());
        agentUser.setCreateTime(new Date());
        agentUser.setEmail(newUser.getEmail());
        agentUser.setSingleAddMoney(request.getSingleAddMoney());
        return agentUserMapper.insertSelective(agentUser) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(AgentUserRequest request, LoginUser loginUser) {
        if (request.getMemId() == null || 0 == request.getMemId()) {
            throw new BusinessException(StatusCode.ACCOUNT_EMPTY.getCode(), "代理ID为空");
        }
        // 检验参数
//        this.validateParams(request);
        AgentUser agentUser = new AgentUser();
        agentUser.setUpdateTime(new Date());
        agentUser.setUpdateUser(loginUser.getAcclogin());
        agentUser.setSingleAddMoney(request.getSingleAddMoney());
        return agentUserMapper.updateByPrimaryKeySelective(agentUser) > 0;
    }


    @Override
    public AgentUserDetailDO userDetail(Long repayMemId) {
        return memRepayuserMapper.selectUserDetailByRepayMemId(repayMemId);
    }

    @Override
    public PageResult userList(AgentUserQuery query, PageBounds page) {
        AgentUser agentUser = new AgentUser();
        agentUser.setEmail(query.getEmail());
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<AgentUser> agentUserList = agentUserMapper.select(agentUser);
        return PageResult.getPageResult(agentUserList.size(), page, agentUserList);
    }

    private void validateParams(AgentUserRequest request) {
        if (StringUtils.isBlank(request.getEmail())) {
            throw new BusinessException(StatusCode.ACCOUNT_EMPTY.getCode(), "账号为空");
        }
        if (StringUtils.isBlank(request.getPassword())) {
            throw new BusinessException(StatusCode.ACCOUNT_EMPTY.getCode(), "密码为空");
        }
        // 检查密码是否过于简单
        List<String> jPwd = CommonFunction.jiandanPwd();
        if (jPwd.contains(request.getPassword())) {
            throw new BusinessException(StatusCode.ACCOUNT_EMPTY.getCode(), "您设置的密码过于简单");
        }
        // 检查账号有效性
        if (!CommonFunction.numbersAndletters(request.getEmail())) {
            throw new BusinessException(StatusCode.ACCOUNT_EMPTY.getCode(), "账号必须为数字或者字母的有效字符");
        }
    }


    private void asynRegister(AgentUserRequest req, MemBaseinfo newUser) {
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
    private void inviteUserProcess(AgentUserRequest req, MemBaseinfo newUser) {
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