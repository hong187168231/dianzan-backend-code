package com.likes.modules.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.likes.common.BaseController;
import com.likes.common.annotation.AdminAccess;
import com.likes.common.model.common.ResultInfo;
import com.likes.modules.pay.service.ICollectService;
import com.likes.modules.pay.vo.GetCollectUrlVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 創世支付回調接口
 *
 * @author bjkj
 */
@AdminAccess
@Controller
@RequestMapping(value = "/cs")
public class CollectController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Resource
    private ICollectService iCollectService;

    @ResponseBody
    @RequestMapping(name = "获取收款地址", value = "/getPayUrl", method = RequestMethod.POST)
    public ResultInfo getCollectUrl(GetCollectUrlVo getCollectUrlVo) {


        logger.error("获取收款地址前端傳入參數,params:{},", JSONObject.toJSONString(getCollectUrlVo));
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            response.setData(iCollectService.getCollectUrl(getCollectUrlVo));
        }catch (Exception e) {
            response = ResultInfo.error("获取收款地址失败");
            logger.error("获取收款地址,出错信息:{}", e);
        }
        logger.info("/getCollectUrl耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

}
