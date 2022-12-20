package com.likes.common.mybatis.entity;

import java.io.Serializable;

public class GodPlanLotteryCategory implements Serializable {
    /**
     * 字段: god_plan_lottery_category.id<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 字段: god_plan_lottery_category.lottery_name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 彩种名称
     *
     * @mbggenerated
     */
    private String lotteryName;

    /**
     * 字段: god_plan_lottery_category.parent_id<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 父级id
     *
     * @mbggenerated
     */
    private Integer parentId;

    /**
     * 字段: god_plan_lottery_category.lottery_id<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 彩种Id
     *
     * @mbggenerated
     */
    private Integer lotteryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table god_plan_lottery_category
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return god_plan_lottery_category.id: id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 字段: god_plan_lottery_category.id<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return god_plan_lottery_category.lottery_name: 彩种名称
     *
     * @mbggenerated
     */
    public String getLotteryName() {
        return lotteryName;
    }

    /**
     * 字段: god_plan_lottery_category.lottery_name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 彩种名称
     *
     * @mbggenerated
     */
    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    /**
     * @return god_plan_lottery_category.parent_id: 父级id
     *
     * @mbggenerated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 字段: god_plan_lottery_category.parent_id<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 父级id
     *
     * @mbggenerated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return god_plan_lottery_category.lottery_id: 彩种Id
     *
     * @mbggenerated
     */
    public Integer getLotteryId() {
        return lotteryId;
    }

    /**
     * 字段: god_plan_lottery_category.lottery_id<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 彩种Id
     *
     * @mbggenerated
     */
    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table god_plan_lottery_category
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
        GodPlanLotteryCategory other = (GodPlanLotteryCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLotteryName() == null ? other.getLotteryName() == null : this.getLotteryName().equals(other.getLotteryName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getLotteryId() == null ? other.getLotteryId() == null : this.getLotteryId().equals(other.getLotteryId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table god_plan_lottery_category
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLotteryName() == null) ? 0 : getLotteryName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getLotteryId() == null) ? 0 : getLotteryId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table god_plan_lottery_category
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
        sb.append(", lotteryName=").append(lotteryName);
        sb.append(", parentId=").append(parentId);
        sb.append(", lotteryId=").append(lotteryId);
        sb.append("]");
        return sb.toString();
    }
}