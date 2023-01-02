package com.likes.common.model.bank;

import com.likes.common.model.common.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@ApiModel
public class MemBankPageReq extends BaseDTO {


    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("银行卡号")
    private String bankCardNo;

    @ApiModelProperty("开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;


}
