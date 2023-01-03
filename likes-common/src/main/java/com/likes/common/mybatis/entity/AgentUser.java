package com.likes.common.mybatis.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "`agent_user`")
public class AgentUser {
    @Id
    @Column(name = "`agent_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;
    @Column(name = "`accno`")
    private String accno;

    @Column(name = "`singel_add_money`")
    private Integer singleAddMoney;

    @Column(name = "`create_user`")
    private Date createUser;

    @Column(name = "`update_user`")
    private Date updateUser;
    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`update_time`")
    private Date updateTime;


}