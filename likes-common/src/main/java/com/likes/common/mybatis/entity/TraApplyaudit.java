package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TraApplyaudit implements Serializable {
    /**
     * 字段: tra_applyaudit.apauditid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 提现稽核对账表
     *
     * @mbggenerated
     */
    private Long apauditid;

    /**
     * 字段: tra_applyaudit.apycid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 提现申请id
     *
     * @mbggenerated
     */
    private Long apycid;

    /**
     * 字段: tra_applyaudit.orderid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 充值订单id
     *
     * @mbggenerated
     */
    private Long orderid;

    /**
     * 字段: tra_applyaudit.paysetid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 支付设定id
     *
     * @mbggenerated
     */
    private Long paysetid;

    /**
     * 字段: tra_applyaudit.auditamt<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 16<br/>
     * 说明: 常态性稽核费（元）
     *
     * @mbggenerated
     */
    private BigDecimal auditamt;

    /**
     * 字段: tra_applyaudit.codesize<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 16<br/>
     * 说明: 打码量
     *
     * @mbggenerated
     */
    private BigDecimal codesize;

    /**
     * 字段: tra_applyaudit.is_delete<br/>
     * 必填: true<br/>
     * 缺省: b'0'<br/>
     * 长度: 1<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * 字段: tra_applyaudit.create_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 字段: tra_applyaudit.create_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 字段: tra_applyaudit.update_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 最后修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 字段: tra_applyaudit.update_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 字段: tra_applyaudit.source<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 订单来自那张表；0 订单表，1加款表
     *
     * @mbggenerated
     */
    private Integer source;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tra_applyaudit
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return tra_applyaudit.apauditid: 提现稽核对账表
     *
     * @mbggenerated
     */
    public Long getApauditid() {
        return apauditid;
    }

    /**
     * 字段: tra_applyaudit.apauditid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 提现稽核对账表
     *
     * @mbggenerated
     */
    public void setApauditid(Long apauditid) {
        this.apauditid = apauditid;
    }

    /**
     * @return tra_applyaudit.apycid: 提现申请id
     *
     * @mbggenerated
     */
    public Long getApycid() {
        return apycid;
    }

    /**
     * 字段: tra_applyaudit.apycid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 提现申请id
     *
     * @mbggenerated
     */
    public void setApycid(Long apycid) {
        this.apycid = apycid;
    }

    /**
     * @return tra_applyaudit.orderid: 充值订单id
     *
     * @mbggenerated
     */
    public Long getOrderid() {
        return orderid;
    }

    /**
     * 字段: tra_applyaudit.orderid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 充值订单id
     *
     * @mbggenerated
     */
    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    /**
     * @return tra_applyaudit.paysetid: 支付设定id
     *
     * @mbggenerated
     */
    public Long getPaysetid() {
        return paysetid;
    }

    /**
     * 字段: tra_applyaudit.paysetid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 支付设定id
     *
     * @mbggenerated
     */
    public void setPaysetid(Long paysetid) {
        this.paysetid = paysetid;
    }

    /**
     * @return tra_applyaudit.auditamt: 常态性稽核费（元）
     *
     * @mbggenerated
     */
    public BigDecimal getAuditamt() {
        return auditamt;
    }

    /**
     * 字段: tra_applyaudit.auditamt<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 16<br/>
     * 说明: 常态性稽核费（元）
     *
     * @mbggenerated
     */
    public void setAuditamt(BigDecimal auditamt) {
        this.auditamt = auditamt;
    }

    /**
     * @return tra_applyaudit.codesize: 打码量
     *
     * @mbggenerated
     */
    public BigDecimal getCodesize() {
        return codesize;
    }

    /**
     * 字段: tra_applyaudit.codesize<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 16<br/>
     * 说明: 打码量
     *
     * @mbggenerated
     */
    public void setCodesize(BigDecimal codesize) {
        this.codesize = codesize;
    }

    /**
     * @return tra_applyaudit.is_delete: 是否删除
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 字段: tra_applyaudit.is_delete<br/>
     * 必填: true<br/>
     * 缺省: b'0'<br/>
     * 长度: 1<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return tra_applyaudit.create_user: 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 字段: tra_applyaudit.create_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return tra_applyaudit.create_time: 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 字段: tra_applyaudit.create_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return tra_applyaudit.update_user: 最后修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 字段: tra_applyaudit.update_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 最后修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return tra_applyaudit.update_time: 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 字段: tra_applyaudit.update_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return tra_applyaudit.source: 订单来自那张表；0 订单表，1加款表
     *
     * @mbggenerated
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 字段: tra_applyaudit.source<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 订单来自那张表；0 订单表，1加款表
     *
     * @mbggenerated
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_applyaudit
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TraApplyaudit other = (TraApplyaudit) that;
        return (this.getApauditid() == null ? other.getApauditid() == null : this.getApauditid().equals(other.getApauditid()))
            && (this.getApycid() == null ? other.getApycid() == null : this.getApycid().equals(other.getApycid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getPaysetid() == null ? other.getPaysetid() == null : this.getPaysetid().equals(other.getPaysetid()))
            && (this.getAuditamt() == null ? other.getAuditamt() == null : this.getAuditamt().equals(other.getAuditamt()))
            && (this.getCodesize() == null ? other.getCodesize() == null : this.getCodesize().equals(other.getCodesize()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_applyaudit
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApauditid() == null) ? 0 : getApauditid().hashCode());
        result = prime * result + ((getApycid() == null) ? 0 : getApycid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getPaysetid() == null) ? 0 : getPaysetid().hashCode());
        result = prime * result + ((getAuditamt() == null) ? 0 : getAuditamt().hashCode());
        result = prime * result + ((getCodesize() == null) ? 0 : getCodesize().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tra_applyaudit
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", apauditid=").append(apauditid);
        sb.append(", apycid=").append(apycid);
        sb.append(", orderid=").append(orderid);
        sb.append(", paysetid=").append(paysetid);
        sb.append(", auditamt=").append(auditamt);
        sb.append(", codesize=").append(codesize);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", source=").append(source);
        sb.append("]");
        return sb.toString();
    }
}