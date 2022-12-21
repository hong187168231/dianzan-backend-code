package com.likes.common.mybatis.entity;

import com.sun.org.glassfish.gmbal.DescriptorFields;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "`inf_sysnotice`")
@Data
public class InfSysnotice {
    /**
     * 公告id
     */
    @Id
    @Column(name = "`noticeid`")
    private Long noticeid;

    /**
     * 消息类型 1直播间滚动消息 2弹窗公告 3首页公告 4短视讯公告
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 会员标识号
     */
    @Column(name = "`accno`")
    private String accno;

    /**
     * 消息标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 消息内容
     */
    @Column(name = "`notebody`")
    private String notebody;

    @Column(name = "`en_notice`")
    private String enNotice;

    @Column(name = "`sp_notice`")
    private String spNotice;

    @Column(name = "`ab_notice`")
    private String abNotice;

    @Column(name = "`fn_notice`")
    private String fnNotice;

    @Column(name = "`vi_notice`")
    private String viNotice;

    /**
     * 消息参数
     */
    @Column(name = "`params`")
    private String params;

    /**
     * 有效期起
     */
    @Column(name = "`expirydates`")
    private Date expirydates;

    /**
     * 有效期止
     */
    @Column(name = "`expirydatee`")
    private Date expirydatee;

    /**
     * 排序权重
     */
    @Column(name = "`sortby`")
    private Integer sortby;

    /**
     * 0 关闭  1 开启
     */
    @Column(name = "`work_status`")
    private Boolean workStatus;

    /**
     * 是否删除
     */
    @Column(name = "`is_delete`")
    private Boolean isDelete;

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