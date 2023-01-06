package com.likes.common.mybatis.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "`mem_baseinfo`")
public class MemBaseinfo {

    /**
     * 用户id
     */
    @Id
    @Column(name = "`memid`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memid;

    /**
     * 会员ID
     */
    @Column(name = "`unique_id`")
    private String uniqueId;

    /**
     * 会员标识号
     */
    @Column(name = "`accno`")
    private String accno;

    @Column(name = "`superior_id`")
    private String superiorId;

    /**
     * 呢称
     */
    @Column(name = "`nickname`")
    private String nickname;

    /**
     * 真实姓名
     */
    @Column(name = "`memname`")
    private String memname;

    /**
     * 手机号码
     */
    @Column(name = "`email`")
    private String email;

    @Column(name = "`mobileno`")
    private String mobileno;

    /**
     * 性别 1男 2女 4保密
     */
    @Column(name = "`sex`")
    private Integer sex;

    @Column(name = "`level`")
    private Integer level;

    /**
     * 证件类型DDINFO
     */
    @Column(name = "`idcardtype`")
    private String idcardtype;

    /**
     * 证件号码
     */
    @Column(name = "`idcardno`")
    private String idcardno;

    /**
     * 证件照片正面
     */
    @Column(name = "`idcardfront`")
    private String idcardfront;

    /**
     * 证件照片反面
     */
    @Column(name = "`idcardback`")
    private String idcardback;

    /**
     * 出生日期
     */
    @Column(name = "`birthday`")
    private Date birthday;

    /**
     * 国籍DDINFO
     */
    @Column(name = "`nationality`")
    private String nationality;

    /**
     * 头像
     */
    @Column(name = "`headimg`")
    private String headimg;

    /**
     * 注册日期
     */
    @Column(name = "`registerdate`")
    private Date registerdate;

    /**
     * 推荐码
     */
    @Column(name = "`recomcode`")
    private String recomcode;

    /**
     * 描述
     */
    @Column(name = "`describes`")
    private String describes;

    /**
     * 登录地址城市
     */
    @Column(name = "`tag`")
    private String tag;

    /**
     * 登录ip地址
     */
    @Column(name = "`clintipadd`")
    private String clintipadd;

    /**
     * 注册ip
     */
    @Column(name = "`register_ip`")
    private String registerIp;

    /**
     * 注册设备
     */
    @Column(name = "`register_dev`")
    private String registerDev;

    /**
     * 登录设备
     */
    @Column(name = "`last_login_dev`")
    private String lastLoginDev;

    /**
     * 登录国家
     */
    @Column(name = "`logincountry`")
    private String logincountry;

    /**
     * 会员特征(兴趣)
     */
    @Column(name = "`memfeatures`")
    private String memfeatures;

    /**
     * 来源 recommend推荐  regist注册  operator运营人员
     */
    @Column(name = "`memorgin`")
    private String memorgin;

    /**
     * 粉丝数量
     */
    @Column(name = "`fansnum`")
    private Long fansnum;

    /**
     * 用户乐币数量
     */
    @Column(name = "`goldnum`")
    private BigDecimal goldnum;

    /**
     * 待开奖金额（元）
     */
    @Column(name = "`wait_amount`")
    private BigDecimal waitAmount;

    /**
     * 可提现余额
     */
    @Column(name = "`withdrawal_remainder`")
    private BigDecimal withdrawalRemainder;

    /**
     * 累计投注  (元)
     */
    @Column(name = "`bet_amount`")
    private BigDecimal betAmount;

    /**
     * 累计充值（元）
     */
    @Column(name = "`pay_amount`")
    private BigDecimal payAmount;

    /**
     * 最大充值金额
     */
    @Column(name = "`pay_max`")
    private BigDecimal payMax;

    /**
     * 首次充值金额
     */
    @Column(name = "`pay_first`")
    private BigDecimal payFirst;

    /**
     * 充值总次数
     */
    @Column(name = "`pay_num`")
    private Integer payNum;

    /**
     * 累计提现（元)
     */
    @Column(name = "`withdrawal_amount`")
    private BigDecimal withdrawalAmount;

    /**
     * 最大提现金额
     */
    @Column(name = "`withdrawal_max`")
    private BigDecimal withdrawalMax;

    /**
     * 首次提现金额
     */
    @Column(name = "`withdrawal_first`")
    private BigDecimal withdrawalFirst;

    /**
     * 提现总次数
     */
    @Column(name = "`withdrawal_num`")
    private Integer withdrawalNum;

    /**
     * 总消费(打码量)
     */
    @Column(name = "`consume_amount`")
    private BigDecimal consumeAmount;

    /**
     * 不可提现金额(元)
     */
    @Column(name = "`no_withdrawal_amount`")
    private BigDecimal noWithdrawalAmount;

    /**
     * 聊天状态: 0,不允许;1,允许
     */
    @Column(name = "`chat_status`")
    private Integer chatStatus;

    @Column(name = "`invit_status`")
    private Integer invitStatus;

    /**
     * 冻结状态: 0,不冻结;1,冻结
     */
    @Column(name = "`freeze_status`")
    private Integer freezeStatus;

    /**
     * 投注状态: 0,不允许;1,允许
     */
    @Column(name = "`bet_status`")
    private Integer betStatus;

    /**
     * 返水状态: 0,不允许;1,允许
     */
    @Column(name = "`backwater_status`")
    private Integer backwaterStatus;

    /**
     * 晒单状态(圈子使用): 0,不允许;1,允许
     */
    @Column(name = "`share_order_status`")
    private Integer shareOrderStatus;

    /**
     * 账户类型  普通会员1      主播2   家族長3   运营后台管理员8    第三方登录7   服務註冊中心管理員9  聚合站点后台管理员10
     */
    @Column(name = "`logintype`")
    private Integer logintype;


    @Column(name = "`agent_level`")
    private Integer agentLevel;

    /**
     * 第三方登录时返回的唯一标识
     */
    @Column(name = "`openId`")
    private String openid;

    /**
     * 所在地(省市区)12位區域編碼code
     */
    @Column(name = "`sitearea`")
    private String sitearea;

    /**
     * 微信号
     */
    @Column(name = "`wechat`")
    private String wechat;

    /**
     * 微信昵称
     */
    @Column(name = "`chatnickname`")
    private String chatnickname;

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

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;


    /**
     * 备注
     */
    @Column(name = "`cg_nickname`")
    private Boolean cgNickname;


    /**
     * 备注
     */
    @Column(name = "`proxy_url`")
    private String proxyUrl;


}