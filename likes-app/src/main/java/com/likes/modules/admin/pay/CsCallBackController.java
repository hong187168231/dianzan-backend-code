package com.likes.modules.admin.pay;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.BaseController;
import com.likes.common.annotation.AdminAccess;
import com.likes.modules.admin.pay.dto.cs.CSCallBackVoPrev;
import com.likes.modules.admin.pay.dto.cs.CSNoticeVo;
import com.likes.modules.admin.pay.service.CsPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 創世支付回調接口
 *
 * @author
 */
@AdminAccess
@Controller
@RequestMapping(value = "/cs")
public class CsCallBackController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CsPayService csPayService;

    @ResponseBody
    @RequestMapping(name = "创世异步通知", value = "/csNotice", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public CSCallBackVoPrev csNotice(CSNoticeVo csNoticeVo) {

        logger.error("创世异步通知傳入參數,params:{},", JSONObject.toJSONString(csNoticeVo));
        long start = System.currentTimeMillis();
        CSCallBackVoPrev csCallBackVoPrev = null;
        try {
            csCallBackVoPrev = csPayService.csNotice(csNoticeVo);
        }catch (Exception e) {
            csCallBackVoPrev = new CSCallBackVoPrev();
            csCallBackVoPrev.setCode("9999");
            csCallBackVoPrev.setMsg("系统异常错误");
            logger.error("{}.userList创世异步通知出错,出错信息:{}", getClass().getName(), e);
        }
        logger.info("/csNotice耗时{}毫秒：", (System.currentTimeMillis() - start));
        return csCallBackVoPrev;
    }

}
