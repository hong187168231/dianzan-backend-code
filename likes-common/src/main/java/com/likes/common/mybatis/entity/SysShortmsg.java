package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class SysShortmsg implements Serializable {
    /**
     * 字段: sys_shortmsg.shortmsgid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 短信ID
     *
     * @mbggenerated
     */
    private Long shortmsgid;

    /**
     * 字段: sys_shortmsg.mobileno<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 15<br/>
     * 说明: 手机号码
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 字段: sys_shortmsg.msgtype<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1<br/>
     * 说明: 短信类型 1短信登陆 ;2找回密码 ;3注册；4.修改密码 8提醒  9其他普通短信
     *
     * @mbggenerated
     */
    private Integer msgtype;

    /**
     * 字段: sys_shortmsg.masdate<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 短信发送时间
     *
     * @mbggenerated
     */
    private Date masdate;

    /**
     * 字段: sys_shortmsg.masbody<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 400<br/>
     * 说明: 短信内容
     *
     * @mbggenerated
     */
    private String masbody;

    /**
     * 字段: sys_shortmsg.msgcode<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 相关编码 对应存储相关类型的编码，如验证码，提醒相关id或订单编号
     *
     * @mbggenerated
     */
    private String msgcode;

    /**
     * 字段: sys_shortmsg.masstatus<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 状态 0发送成功 8已使用 9发送失败
     *
     * @mbggenerated
     */
    private String masstatus;

    /**
     * 字段: sys_shortmsg.ipaddress<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 200<br/>
     * 说明: 发送短信ip地址
     *
     * @mbggenerated
     */
    private String ipaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_shortmsg
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return sys_shortmsg.shortmsgid: 短信ID
     *
     * @mbggenerated
     */
    public Long getShortmsgid() {
        return shortmsgid;
    }

    /**
     * 字段: sys_shortmsg.shortmsgid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 短信ID
     *
     * @mbggenerated
     */
    public void setShortmsgid(Long shortmsgid) {
        this.shortmsgid = shortmsgid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return sys_shortmsg.msgtype: 短信类型 1短信登陆 ;2找回密码 ;3注册；4.修改密码 8提醒  9其他普通短信
     *
     * @mbggenerated
     */
    public Integer getMsgtype() {
        return msgtype;
    }

    /**
     * 字段: sys_shortmsg.msgtype<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1<br/>
     * 说明: 短信类型 1短信登陆 ;2找回密码 ;3注册；4.修改密码 8提醒  9其他普通短信
     *
     * @mbggenerated
     */
    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * @return sys_shortmsg.masdate: 短信发送时间
     *
     * @mbggenerated
     */
    public Date getMasdate() {
        return masdate;
    }

    /**
     * 字段: sys_shortmsg.masdate<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 短信发送时间
     *
     * @mbggenerated
     */
    public void setMasdate(Date masdate) {
        this.masdate = masdate;
    }

    /**
     * @return sys_shortmsg.masbody: 短信内容
     *
     * @mbggenerated
     */
    public String getMasbody() {
        return masbody;
    }

    /**
     * 字段: sys_shortmsg.masbody<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 400<br/>
     * 说明: 短信内容
     *
     * @mbggenerated
     */
    public void setMasbody(String masbody) {
        this.masbody = masbody;
    }

    /**
     * @return sys_shortmsg.msgcode: 相关编码 对应存储相关类型的编码，如验证码，提醒相关id或订单编号
     *
     * @mbggenerated
     */
    public String getMsgcode() {
        return msgcode;
    }

    /**
     * 字段: sys_shortmsg.msgcode<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 相关编码 对应存储相关类型的编码，如验证码，提醒相关id或订单编号
     *
     * @mbggenerated
     */
    public void setMsgcode(String msgcode) {
        this.msgcode = msgcode;
    }

    /**
     * @return sys_shortmsg.masstatus: 状态 0发送成功 8已使用 9发送失败
     *
     * @mbggenerated
     */
    public String getMasstatus() {
        return masstatus;
    }

    /**
     * 字段: sys_shortmsg.masstatus<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 状态 0发送成功 8已使用 9发送失败
     *
     * @mbggenerated
     */
    public void setMasstatus(String masstatus) {
        this.masstatus = masstatus;
    }

    /**
     * @return sys_shortmsg.ipaddress: 发送短信ip地址
     *
     * @mbggenerated
     */
    public String getIpaddress() {
        return ipaddress;
    }

    /**
     * 字段: sys_shortmsg.ipaddress<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 200<br/>
     * 说明: 发送短信ip地址
     *
     * @mbggenerated
     */
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }


}
