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

    @Column(name = "`email`")
    private String email;
    @Column(name = "`singel_add_money`")
    private Integer singleAddMoney;

    @Column(name = "`create_user`")
    private String createUser;

    @Column(name = "`update_user`")
    private String updateUser;

    @Column(name = "`ser_url`")
    private String serUrl;

    @Column(name = "`create_time`")
    private Date createTime;

    @Column(name = "`update_time`")
    private Date updateTime;


}