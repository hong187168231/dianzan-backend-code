package com.likes.common.mybatis.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "`mem_level_config`")
@Data
public class MemLevelConfig {
    /**
     * 等级id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 当前等级
     */
    @Column(name = "`level`")
    private String level;

    /**
     * 等级编号
     */
    @Column(name = "`level_seq`")
    private Integer levelSeq;

    /**
     * 等级图标地址
     */
    @Column(name = "`level_icon_url`")
    private String levelIconUrl;

    @Column(name = "`image_url`")
    private String imageUrl;

    /**
     * 所需购买金额
     */
    @Column(name = "`recharge_amount`")
    private BigDecimal rechargeAmount;

    /**
     * 推广获得金额
     */
    @Column(name = "`promote_amount`")
    private BigDecimal promoteAmount;

    @Column(name = "`take_amount`")
    private BigDecimal takeAmount;

    /**
     * 任务次数
     */
    @Column(name = "`do_task_times`")
    private Integer doTaskTimes;

    /**
     * 有效时长 按月 如 12
     */
    @Column(name = "`expire_time`")
    private Integer expireTime;

    /**
     * 是否删除
     */
    @Column(name = "`is_delete`")
    private Integer isDelete;

    /**
     * 创建人
     */
    @Column(name = "`create_user`")
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 最后修改人
     */
    @Column(name = "`update_user`")
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;


}
