package com.likes.modules.admin.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.likes.common.BaseController;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.HelpManual;
import com.likes.common.model.LoginUser;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.model.request.BaseRequest;
import com.likes.common.mybatis.mapper.HelpManualMapper;
import com.likes.common.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class HelpManualController extends BaseController {

    private final Logger logger = LogManager.getLogger(HelpManualController.class);

    @Resource
    private HelpManualMapper manualMapper;

    @RequestMapping(name = "添加帮助文档", value = "helpManual/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo AddHelpManual(HelpManual helpManual) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            if (com.likes.common.util.StringUtils.isBlank(helpManual.getTitle())) {
                return ResultInfo.error("帮助文档标题不能为空");
            }
            if (StringUtils.isBlank(helpManual.getContent())) {
                return ResultInfo.error("帮助文档内容不能为空");
            }
            if (helpManual.getSort() == null)helpManual.setSort(0);
            helpManual.setCreateTime(new Date());
            int row = manualMapper.insertSelective(helpManual);
            response.setData(row);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("/AddHelpManual:{}", e.getMessage());
        }
        logger.info("/AddHelpManual{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

    @RequestMapping(name = "编辑帮助文档", value = "helpManual/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo EditHelpManual(HelpManual helpManual) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            if (helpManual.getId() == null) {
                return ResultInfo.error("帮助文档编号不能为空");
            }
            if (com.likes.common.util.StringUtils.isBlank(helpManual.getTitle())) {
                return ResultInfo.error("帮助文档标题不能为空");
            }
            if (StringUtils.isBlank(helpManual.getContent())) {
                return ResultInfo.error("帮助文档内容不能为空");
            }

            if (helpManual.getSort() == null)helpManual.setSort(0);

            int row = manualMapper.updateByPrimaryKey(helpManual);
            response.setData(row);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("/EditHelpManual:{}", e.getMessage());
        }
        logger.info("/EditHelpManual{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

    @RequestMapping(name = "删除帮助文档", value = "helpManual/del", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo DelHelpManual(HelpManual helpManual) {
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            LoginUser loginUser = getLoginAdmin();
            if (helpManual.getId() == null) {
                return ResultInfo.error("帮助文档编号不能为空");
            }
            int row = manualMapper.deleteByPrimaryKey(helpManual);
            response.setData(row);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("/DelHelpManual:{}", e.getMessage());
        }
        logger.info("/DelHelpManual{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }

    @RequestMapping(name = "分页帮助文档", value = "helpManual/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo Paging(BaseRequest req,String keyWord){
        long start = System.currentTimeMillis();
        ResultInfo response = ResultInfo.ok();
        try {
            PageHelper.startPage(req.getPageNo(), req.getPageSize());
            List<HelpManual> list = manualMapper.getList(keyWord);
            PageInfo<HelpManual> pageInfo = new PageInfo<>(list);
            response.setData(pageInfo);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.info("helpManual/list:{}", e.getMessage());
        }
        logger.info("helpManual/list耗时{}毫秒：", (System.currentTimeMillis() - start));
        return response;
    }
}
