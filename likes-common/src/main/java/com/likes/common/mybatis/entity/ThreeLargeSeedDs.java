package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class ThreeLargeSeedDs implements Serializable {
    /**
     * 字段: three_large_seed_ds.id<br/>
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
     * 字段: three_large_seed_ds.year<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 5<br/>
     * 说明: 年份
     *
     * @mbggenerated
     */
    private String year;

    /**
     * 字段: three_large_seed_ds.issue<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 期号
     *
     * @mbggenerated
     */
    private String issue;

    /**
     * 字段: three_large_seed_ds.num_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 玩法类型
     *
     * @mbggenerated
     */
    private Integer numType;

    /**
     * 字段: three_large_seed_ds.largeD<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: D路
     *
     * @mbggenerated
     */
    private Integer larged;

    /**
     * 字段: three_large_seed_ds.largeE<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: E路
     *
     * @mbggenerated
     */
    private Integer largee;

    /**
     * 字段: three_large_seed_ds.rule_two_flag<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    private Integer ruleTwoFlag;

    /**
     * 字段: three_large_seed_ds.rule_three_flag<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 是否规则三计算
     *
     * @mbggenerated
     */
    private Integer ruleThreeFlag;

    /**
     * 字段: three_large_seed_ds.create_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 字段: three_large_seed_ds.update_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 字段: three_large_seed_ds.deleted<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 数据删除标识
     *
     * @mbggenerated
     */
    private Integer deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table three_large_seed_ds
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return three_large_seed_ds.id: 
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 字段: three_large_seed_ds.id<br/>
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
     * @return three_large_seed_ds.year: 年份
     *
     * @mbggenerated
     */
    public String getYear() {
        return year;
    }

    /**
     * 字段: three_large_seed_ds.year<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 5<br/>
     * 说明: 年份
     *
     * @mbggenerated
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return three_large_seed_ds.issue: 期号
     *
     * @mbggenerated
     */
    public String getIssue() {
        return issue;
    }

    /**
     * 字段: three_large_seed_ds.issue<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 期号
     *
     * @mbggenerated
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * @return three_large_seed_ds.num_type: 玩法类型
     *
     * @mbggenerated
     */
    public Integer getNumType() {
        return numType;
    }

    /**
     * 字段: three_large_seed_ds.num_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 玩法类型
     *
     * @mbggenerated
     */
    public void setNumType(Integer numType) {
        this.numType = numType;
    }

    /**
     * @return three_large_seed_ds.largeD: D路
     *
     * @mbggenerated
     */
    public Integer getLarged() {
        return larged;
    }

    /**
     * 字段: three_large_seed_ds.largeD<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: D路
     *
     * @mbggenerated
     */
    public void setLarged(Integer larged) {
        this.larged = larged;
    }

    /**
     * @return three_large_seed_ds.largeE: E路
     *
     * @mbggenerated
     */
    public Integer getLargee() {
        return largee;
    }

    /**
     * 字段: three_large_seed_ds.largeE<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: E路
     *
     * @mbggenerated
     */
    public void setLargee(Integer largee) {
        this.largee = largee;
    }

    /**
     * @return three_large_seed_ds.rule_two_flag: 
     *
     * @mbggenerated
     */
    public Integer getRuleTwoFlag() {
        return ruleTwoFlag;
    }

    /**
     * 字段: three_large_seed_ds.rule_two_flag<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    public void setRuleTwoFlag(Integer ruleTwoFlag) {
        this.ruleTwoFlag = ruleTwoFlag;
    }

    /**
     * @return three_large_seed_ds.rule_three_flag: 是否规则三计算
     *
     * @mbggenerated
     */
    public Integer getRuleThreeFlag() {
        return ruleThreeFlag;
    }

    /**
     * 字段: three_large_seed_ds.rule_three_flag<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 是否规则三计算
     *
     * @mbggenerated
     */
    public void setRuleThreeFlag(Integer ruleThreeFlag) {
        this.ruleThreeFlag = ruleThreeFlag;
    }

    /**
     * @return three_large_seed_ds.create_time: 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 字段: three_large_seed_ds.create_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return three_large_seed_ds.update_time: 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 字段: three_large_seed_ds.update_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return three_large_seed_ds.deleted: 数据删除标识
     *
     * @mbggenerated
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 字段: three_large_seed_ds.deleted<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 数据删除标识
     *
     * @mbggenerated
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_large_seed_ds
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
        ThreeLargeSeedDs other = (ThreeLargeSeedDs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
            && (this.getNumType() == null ? other.getNumType() == null : this.getNumType().equals(other.getNumType()))
            && (this.getLarged() == null ? other.getLarged() == null : this.getLarged().equals(other.getLarged()))
            && (this.getLargee() == null ? other.getLargee() == null : this.getLargee().equals(other.getLargee()))
            && (this.getRuleTwoFlag() == null ? other.getRuleTwoFlag() == null : this.getRuleTwoFlag().equals(other.getRuleTwoFlag()))
            && (this.getRuleThreeFlag() == null ? other.getRuleThreeFlag() == null : this.getRuleThreeFlag().equals(other.getRuleThreeFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_large_seed_ds
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
        result = prime * result + ((getNumType() == null) ? 0 : getNumType().hashCode());
        result = prime * result + ((getLarged() == null) ? 0 : getLarged().hashCode());
        result = prime * result + ((getLargee() == null) ? 0 : getLargee().hashCode());
        result = prime * result + ((getRuleTwoFlag() == null) ? 0 : getRuleTwoFlag().hashCode());
        result = prime * result + ((getRuleThreeFlag() == null) ? 0 : getRuleThreeFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_large_seed_ds
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
        sb.append(", year=").append(year);
        sb.append(", issue=").append(issue);
        sb.append(", numType=").append(numType);
        sb.append(", larged=").append(larged);
        sb.append(", largee=").append(largee);
        sb.append(", ruleTwoFlag=").append(ruleTwoFlag);
        sb.append(", ruleThreeFlag=").append(ruleThreeFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}