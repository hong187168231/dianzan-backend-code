package com.likes.common.mybatis.entity;

import java.io.Serializable;

public class MemberChatRecord implements Serializable {
    /**
     * 字段: member_chat_record.id<br/>
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
     * 字段: member_chat_record.member_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 会员id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * 字段: member_chat_record.account<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 会员账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 字段: member_chat_record.message<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 内容
     *
     * @mbggenerated
     */
    private String message;

    /**
     * 字段: member_chat_record.create_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 操作时间
     *
     * @mbggenerated
     */
    private String createTime;

    /**
     * 字段: member_chat_record.deleted<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 是否删除;0,否;1,是
     *
     * @mbggenerated
     */
    private Integer deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table member_chat_record
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return member_chat_record.id: 
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 字段: member_chat_record.id<br/>
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
     * @return member_chat_record.member_id: 会员id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 字段: member_chat_record.member_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 会员id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * @return member_chat_record.account: 会员账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 字段: member_chat_record.account<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 会员账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return member_chat_record.message: 内容
     *
     * @mbggenerated
     */
    public String getMessage() {
        return message;
    }

    /**
     * 字段: member_chat_record.message<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 内容
     *
     * @mbggenerated
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return member_chat_record.create_time: 操作时间
     *
     * @mbggenerated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 字段: member_chat_record.create_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 操作时间
     *
     * @mbggenerated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return member_chat_record.deleted: 是否删除;0,否;1,是
     *
     * @mbggenerated
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 字段: member_chat_record.deleted<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 是否删除;0,否;1,是
     *
     * @mbggenerated
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_chat_record
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
        MemberChatRecord other = (MemberChatRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_chat_record
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_chat_record
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
        sb.append(", memberId=").append(memberId);
        sb.append(", account=").append(account);
        sb.append(", message=").append(message);
        sb.append(", createTime=").append(createTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}