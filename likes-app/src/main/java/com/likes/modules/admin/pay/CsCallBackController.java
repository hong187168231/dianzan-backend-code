package com.likes.modules.admin.pay;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.annotation.AllowAccess;
import com.likes.common.model.dto.pay.CSCallBackVoPrev;
import com.likes.common.model.dto.pay.CsPayNoticeReq;
import com.likes.common.service.pay.CsPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 創世支付回調接口
 *
 * @author
 */

@RestController
@RequestMapping(value = "/cs")
@Slf4j
@Api(tags = "支付回调")
public class CsCallBackController {
    @Resource
    private CsPayService csPayService;

    @ApiOperation("传世支付回调")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "params", required = true),
            @ApiImplicitParam(name = "mcode", value = "mcode", required = true)
    })
    @AllowAccess
    @PostMapping(name = "创世异步通知", value = "callback")
    public CSCallBackVoPrev csNotice(@RequestParam("params") String params,@RequestParam("mcode") String mcode) {
        CsPayNoticeReq csPayNoticeReq = new CsPayNoticeReq();
        csPayNoticeReq.setParams(params);
        csPayNoticeReq.setMcode(mcode);
        log.error("创世异步通知传入参数,params:{},", JSONObject.toJSONString(csPayNoticeReq));
        long start = System.currentTimeMillis();
        CSCallBackVoPrev csCallBackVoPrev;
        try {
            csCallBackVoPrev = csPayService.callbackNotice(csPayNoticeReq);
        } catch (Exception e) {
            log.error("/我方回调参数出现异常",params);
            csCallBackVoPrev = new CSCallBackVoPrev();
            csCallBackVoPrev.setCode("9999");
            csCallBackVoPrev.setMsg("系统异常错误");
            log.error("{}.callback创世异步通知出错,出错信息:{}", getClass().getName(), e);
            return csCallBackVoPrev;
        }
        log.info("/callback耗时{}毫秒：", (System.currentTimeMillis() - start));
        log.error("/我方回调参数", JSONObject.toJSONString(csCallBackVoPrev));
        return csCallBackVoPrev;
    }


//    {"mcode":"gxtnxaciwhdg","params":"c1ZnS0MyaHNmRXZTdHRiNGVHTEhvdExFYS82cVY5RkhqWEV0SFRMc1ZOTzhyR1FxNno2ck5sd0xSQXd5azB4SDVsdURuTWNxYmZuZnROQktLdHFJbytXNjJSdXVTV1BtTlB2dytUQ09nM2Y5Z2hzOVBBUlVITkR3UEo1TG1vV25qc1J6dXN4RE5IcUNwaFhVQUFjQms5L2dXaHErd3pYcURNUStGeWtnL1hkNm1sS3lhbXRMRmxSNG9URnRieGh0SHdkWUl6TXJiU3lTaHMxLzZsKzRPbCthczlJYmNVRlRvVitBUTNKbk9sRnRnWXFNdktVY0tmVkd4MkE4eVloUjQ2ZXFPZ2VJNVJCaTh2VlkxdG4rV3NYR1lxbThFUzZCQ3NmUllPT2pWSmc3MEhXUWFIY3BFTGxWYW5GamRvR1NNNHFGdHRXR09KOVZtaXQ0NXBFcit1WnVnay94emFSL3NNL3ZibnhOWE5iRXJTOEFrNkxvbFBaSnpkM3FhemZBSHZGUUtSSnowREIvSlU0NFRib2pjQ3EzVzFXZFFjWnFxbXNYaUJZZGFuUjg4dDhJZ0VSUkVSQVAwbkpJWG81Z2xiV0RJSU5TNm9UZTk1djdhajBwaGc9PQ=="},]
//            2023-01-08 21:21:40 DEBUG [com.likes.common.mybatis.m

}