package com.likes.modules.admin.file.controller.controller;

import com.likes.common.annotation.AllowAccess;
import com.likes.common.exception.BusinessException;
import com.likes.common.model.common.ResultInfo;
import com.likes.common.service.uploadFile.MinioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/uploadFiles")
@Api(tags = "文件上传")
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MinioService minioService;


    @PostMapping
    @ApiOperation(value = "文件上传")
    @AllowAccess
    public ResultInfo<String> uploadFile(
            @RequestPart(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "bucketName", required = false) String bucketName
    ) {
        String path = null;
        ResultInfo response = ResultInfo.ok();
        try {
            path = minioService.putObject(file, bucketName);
        } catch (BusinessException e) {
            response.setResultInfo(e.getCode(), e.getMessage());
            logger.error("{}.uploadFiles 文件上传出错,出错信息:{}", getClass().getName(), e.getMessage(), e);
        } catch (Exception e) {
            response = ResultInfo.error("文件上传失败");
            logger.error("{}.guploadFiles 文件上传处理出错,出错信息:{}", getClass().getName(), e.getMessage(), e);
        }
        return ResultInfo.ok(path);
    }


}