package com.likes.common.mybatis.entity;

import java.io.Serializable;

public class GiftMoneyRecord implements Serializable {
    /**
     * 字段: gift_money_record.id<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 字段: gift_money_record.name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 字段: gift_money_record.account<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 用户账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 字段: gift_money_record.money<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 金额
     *
     * @mbggenerated
     */
    private Integer money;

    /**
     * 字段: gift_money_record.type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 字段: gift_money_record.way<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 方式:1,平台入款
     *
     * @mbggenerated
     */
    private Integer way;

    /**
     * 字段: gift_money_record.remark<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 字段: gift_money_record.create_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 时间
     *
     * @mbggenerated
     */
    private String createTime;

    /**
     * 字段: gift_money_record.operater<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 操作员
     *
     * @mbggenerated
     */
    private String operater;

    /**
     * 字段: gift_money_record.member_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 用户id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gift_money_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return gift_money_record.id: 
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 字段: gift_money_record.id<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return gift_money_record.name: 名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 字段: gift_money_record.name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return gift_money_record.account: 用户账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 字段: gift_money_record.account<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 用户账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return gift_money_record.money: 金额
     *
     * @mbggenerated
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 字段: gift_money_record.money<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 金额
     *
     * @mbggenerated
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * @return gift_money_record.type: 
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 字段: gift_money_record.type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return gift_money_record.way: 方式:1,平台入款
     *
     * @mbggenerated
     */
    public Integer getWay() {
        return way;
    }

    /**
     * 字段: gift_money_record.way<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 方式:1,平台入款
     *
     * @mbggenerated
     */
    public void setWay(Integer way) {
        this.way = way;
    }

    /**
     * @return gift_money_record.remark: 备注
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 字段: gift_money_record.remark<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 备注
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return gift_money_record.create_time: 时间
     *
     * @mbggenerated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 字段: gift_money_record.create_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 时间
     *
     * @mbggenerated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return gift_money_record.operater: 操作员
     *
     * @mbggenerated
     */
    public String getOperater() {
        return operater;
    }

    /**
     * 字段: gift_money_record.operater<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 操作员
     *
     * @mbggenerated
     */
    public void setOperater(String operater) {
        this.operater = operater;
    }

    /**
     * @return gift_money_record.member_id: 用户id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 字段: gift_money_record.member_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 用户id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_money_record
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
        GiftMoneyRecord other = (GiftMoneyRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getWay() == null ? other.getWay() == null : this.getWay().equals(other.getWay()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOperater() == null ? other.getOperater() == null : this.getOperater().equals(other.getOperater()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_money_record
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getWay() == null) ? 0 : getWay().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOperater() == null) ? 0 : getOperater().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_money_record
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", account=").append(account);
        sb.append(", money=").append(money);
        sb.append(", type=").append(type);
        sb.append(", way=").append(way);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", operater=").append(operater);
        sb.append(", memberId=").append(memberId);
        sb.append("]");
        return sb.toString();
    }
}