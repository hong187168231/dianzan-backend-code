package com.likes.common.model.response;

import com.likes.common.constant.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class EntryOrderResponse {
    private String orderid;
    private String orderno;
    private String nickname;
    private String uniqueId;
    private BigDecimal realamt;
    private BigDecimal givepercent;
    private Double rechargegold;
    private Double givegold;
    private String payuser;
    private String paynote;
    private String ordernote;
    private String remark;

    private String moneyAddress;
    @ApiModelProperty("付款地址")
    private String payAddress;

    @ApiModelProperty("收款地址")
    private String transferAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
    private Date createdate;
    private String orderstatus;
    private String modifyusername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
    private Date updateTime;
    private Long tpaysetid;
    private String provider;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
    private Date paydate;

    private String completionTime;

    public String getCompletionTime() {
        if (!Constants.ORDER_ORD13.equals(orderstatus) && !Constants.ORDER_ORD08.equals(orderstatus)) {
            return "";
        }
        return DateFormatUtils.format(updateTime, "yyyy-MM-dd HH:mm:ss");
    }


}