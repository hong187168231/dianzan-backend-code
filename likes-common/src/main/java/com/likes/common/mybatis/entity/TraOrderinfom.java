package com.likes.common.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class TraOrderinfom implements Serializable {
    /**
     * 字段: tra_orderinfom.orderid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 订单id
     *
     * @mbggenerated
     */
    private Long orderid;

    /**
     * 字段: tra_orderinfom.mealid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 充值套餐id
     *
     * @mbggenerated
     */
    private Long mealid;

    /**
     * 字段: tra_orderinfom.bankid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 入款账户id
     *
     * @mbggenerated
     */
    private Long bankid;

    /**
     * 字段: tra_orderinfom.roomid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 主播房间id
     *
     * @mbggenerated
     */
    private Long roomid;

    /**
     * 字段: tra_orderinfom.lotkindid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 彩种id
     *
     * @mbggenerated
     */
    private Long lotkindid;

    /**
     * 字段: tra_orderinfom.sschistoryid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 時時彩開獎id
     *
     * @mbggenerated
     */
    private Long sschistoryid;

    /**
     * 字段: tra_orderinfom.oddsid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 投注項id
     *
     * @mbggenerated
     */
    private Long oddsid;

    /**
     * 字段: tra_orderinfom.chekindid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 棋牌分類id
     *
     * @mbggenerated
     */
    private Long chekindid;

    /**
     * 字段: tra_orderinfom.tpaysetid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 三方支付id
     *
     * @mbggenerated
     */
    private Long tpaysetid;

    /**
     * 字段: tra_orderinfom.ordertype<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 2<br/>
     * 说明: 订单类型 1在线支付 2线下支付 3在線提現 4線下提現 5彩票購彩 6彩票兌獎 7棋牌上分 8棋牌下分 9其他收入(發帖/推薦)  10其他支出(打賞)  11代理結算收入 14 代充人入款 15 代充人给会员充值

     *
     * @mbggenerated
     */
    private Integer ordertype;

    /**
     * 字段: tra_orderinfom.orderno<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 40<br/>
     * 说明: 订单编号4码年+2码月+8码流水号，生成逻辑：取当前年月，然后从数据库中取当前年月最大订单号，然后将后面8位流水号+1
     *
     * @mbggenerated
     */
    private String orderno;

    /**
     * 字段: tra_orderinfom.accno<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 会员标识号
     *
     * @mbggenerated
     */
    private String accno;

    /**
     * 字段: tra_orderinfom.paycode<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 64<br/>
     * 说明: 支付标示第三方支付标示号，如支付宝的订单号或微信的prepay_id等
     *
     * @mbggenerated
     */
    private String paycode;

    /**
     * 字段: tra_orderinfom.orderdate<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 订单日期
     *
     * @mbggenerated
     */
    private Date orderdate;

    /**
     * 字段: tra_orderinfom.expiredate<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 过期时间
     *
     * @mbggenerated
     */
    private Date expiredate;

    /**
     * 字段: tra_orderinfom.paytype<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 支付方式  JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付   NETBANK 网银转账  WECHAT 微信收款  ALIPAY 支付宝支付
     *
     * @mbggenerated
     */
    private String paytype;

    /**
     * 字段: tra_orderinfom.oldamt<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 16<br/>
     * 说明: 订单原价
     *
     * @mbggenerated
     */
    private BigDecimal oldamt;

    /**
     * 字段: tra_orderinfom.sumamt<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 16<br/>
     * 说明: 订单总金额
     *
     * @mbggenerated
     */
    private BigDecimal sumamt;

    /**
     * 字段: tra_orderinfom.realamt<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 16<br/>
     * 说明: 实付金额
     *
     * @mbggenerated
     */
    private BigDecimal realamt;

    /**
     * 字段: tra_orderinfom.isinvoice<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1<br/>
     * 说明: 是否开具发票0是 9否
     *
     * @mbggenerated
     */
    private Integer isinvoice;

    /**
     * 字段: tra_orderinfom.orderstatus<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 订单状态 ord01新订单 ord04待付款 ord05提現申請 ord06提現取消 ord07提現處理中 ord08已付款  ord09用户取消 ord10已评价  ord11已退款 ord12已提現  ord98已拉取棋牌訂單 ord99已过期   
     *
     * @mbggenerated
     */
    private String orderstatus;

    /**
     * 字段: tra_orderinfom.accountstatus<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 结算状态 acc04待结算（未打码）  acc08已结算（已打码）  acc99已取消（不可结算）
     *
     * @mbggenerated
     */
    private String accountstatus;

    /**
     * 字段: tra_orderinfom.cancelreason<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 400<br/>
     * 说明: 取消订单原因
     *
     * @mbggenerated
     */
    private String cancelreason;

    /**
     * 字段: tra_orderinfom.payimg<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1000<br/>
     * 说明: 支付凭证截图 多张以“，”分隔
     *
     * @mbggenerated
     */
    private String payimg;

    /**
     * 字段: tra_orderinfom.paywechat<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 支付处理微信号
     *
     * @mbggenerated
     */
    private String paywechat;

    /**
     * 字段: tra_orderinfom.paydate<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 支付时间
     *
     * @mbggenerated
     */
    private Date paydate;

    /**
     * 字段: tra_orderinfom.payuser<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 匯款姓名
     *
     * @mbggenerated
     */
    private String payuser;

    private String payAddress;

    private String transferAddress;

    /**
     * 字段: tra_orderinfom.paynote<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 400<br/>
     * 说明: 匯款備註
     *
     * @mbggenerated
     */
    private String paynote;

    /**
     * 字段: tra_orderinfom.ordernote<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 400<br/>
     * 说明: 备注
     *
     * @mbggenerated
     */
    private String ordernote;

    /**
     * 字段: tra_orderinfom.is_delete<br/>
     * 必填: true<br/>
     * 缺省: b'0'<br/>
     * 长度: 1<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * 字段: tra_orderinfom.create_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 字段: tra_orderinfom.create_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 字段: tra_orderinfom.update_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 最后修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 字段: tra_orderinfom.update_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 字段: tra_orderinfom.source<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 50<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    private String source;

    /**
     * 字段: tra_orderinfom.cleanid<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 19<br/>
     * 说明: 代理结算id,大于0，表示结算过，可追溯被何处结算
     *
     * @mbggenerated
     */
    private Long cleanid;

    /**
     * 字段: tra_orderinfom.buy_vip<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 购买VIP的等级,为空则表示不购买等级
     *
     * @mbggenerated
     */
    private Long buyVip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tra_orderinfom
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;


}