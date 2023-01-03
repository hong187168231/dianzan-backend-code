package com.likes.modules.admin.user.controller;


import com.likes.common.BaseController;
import com.likes.common.annotation.Syslog;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.AgentUserQuery;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.request.AgentUserRequest;
import com.likes.modules.admin.user.service.AgentUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 代充人
 */
@RestController
@Api(tags = "代理用户管理")
@RequestMapping(value = "/agent/user")
public class AgentUserController extends BaseController {

    private final Logger logger = LogManager.getLogger(getClass());

    @Resource
    private AgentUserService agentUserService;


    @ApiOperation("代理新增")
    @Syslog("代理新增")
    @PostMapping(name = "代理新增", value = "/create")
    public ResultInfo createUser(AgentUserRequest request) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            response.setData(agentUserService.createUser(request, loginUser));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("/createUser失败:{}", e.getMessage());
        }
        logger.info("/createUser耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

//    @RequestMapping(name = "代理详情", value = "/detail", method = RequestMethod.GET)
//    public ResultInfo userDetail(Long repaymemid) {
//        long start = System.currentTimeMillis();
//        ResultInfo response = ResultInfo.ok();
//        try {
//            response.setData(agentUserService.userDetail(repaymemid));
//        } catch (BusinessException e) {
//            response.setResultInfo(e.getCode(), e.getMessage());
//            logger.info("/userDetail失败:{}", e.getMessage());
//        }
//        logger.info("/userDetail耗时{}毫秒：", (System.currentTimeMillis() - start));
//        return response;
//    }

    @ApiOperation("代理编辑")
    @Syslog("代理编辑")
    @RequestMapping(name = "代理编辑", value = "/update", method = RequestMethod.POST)
    public ResultInfo updateUser(AgentUserRequest request) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            response.setData(agentUserService.updateUser(request, loginUser));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("/updateUser失败:{}", e.getMessage());
        }
        logger.info("/updateUser耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }


    @ApiOperation("代理列表")
    @RequestMapping(name = "代理列表", value = "/list", method = RequestMethod.GET)
    public ResultInfo userList(AgentUserQuery query, PageBounds page) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(agentUserService.userList(query, page));
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("/userList失败:{}", e.getMessage());
        }
        logger.info("/userList耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }
}