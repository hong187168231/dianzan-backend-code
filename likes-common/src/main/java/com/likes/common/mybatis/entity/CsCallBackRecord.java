package com.likes.common.mybatis.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`cs_callback_record`")
@Data
public class CsCallBackRecord {

    @Id
    @Column(name = "`id`")
    @ApiModelProperty(value = "id")
    private String id;

    @Column(name = "`param`")
    @ApiModelProperty(value = "param")
    private String param;

    @Column(name = "`order_no`")
    @ApiModelProperty(value = "order_no")
    private String orderNo;

    @Column(name = "`create_time`")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;



}