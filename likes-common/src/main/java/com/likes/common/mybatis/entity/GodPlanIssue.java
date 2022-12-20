package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GodPlanIssue implements Serializable {
    /**
     * 字段: god_plan_issue.id<br/>
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
     * 字段: god_plan_issue.issue<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 255<br/>
     * 说明: 期号
     *
     * @mbggenerated
     */
    private String issue;

    /**
     * 字段: god_plan_issue.god_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 大神id（即god_plan_play中id）
     *
     * @mbggenerated
     */
    private Integer godId;

    /**
     * 字段: god_plan_issue.bet_number<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 投注号码
     *
     * @mbggenerated
     */
    private String betNumber;

    /**
     * 字段: god_plan_issue.lottery_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 彩种Id
     *
     * @mbggenerated
     */
    private Integer lotteryId;

    /**
     * 字段: god_plan_issue.play_tag_id<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 玩法Id
     *
     * @mbggenerated
     */
    private Integer playTagId;

    /**
     * 字段: god_plan_issue.setting_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 玩法配置id
     *
     * @mbggenerated
     */
    private Integer settingId;

    /**
     * 字段: god_plan_issue.play_name<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 玩法名称
     *
     * @mbggenerated
     */
    private String playName;

    /**
     * 字段: god_plan_issue.number<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 开奖号码
     *
     * @mbggenerated
     */
    private String number;

    /**
     * 字段: god_plan_issue.status<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 状态（0预推，1待开奖，2已开奖）
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 字段: god_plan_issue.tb_status<br/>
     * 必填: true<br/>
     * 缺省: WAIT<br/>
     * 长度: 255<br/>
     * 说明: 状态：中奖 | 未中奖 | 等待开奖
     *
     * @mbggenerated
     */
    private String tbStatus;

    /**
     * 字段: god_plan_issue.plan_type<br/>
     * 必填: false<br/>
     * 缺省: 1<br/>
     * 长度: 10<br/>
     * 说明: 计划类型（1期，2期，3期）
     *
     * @mbggenerated
     */
    private Integer planType;

    /**
     * 字段: god_plan_issue.ideal_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 开奖时间
     *
     * @mbggenerated
     */
    private Date idealTime;

    /**
     * 字段: god_plan_issue.bet_count<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 投注注数
     *
     * @mbggenerated
     */
    private Integer betCount;

    /**
     * 字段: god_plan_issue.single_money<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    private BigDecimal singleMoney;

    /**
     * 字段: god_plan_issue.reward_amount<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 大神打赏总金额
     *
     * @mbggenerated
     */
    private BigDecimal rewardAmount;

    /**
     * 字段: god_plan_issue.recent_win_count<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 中奖数
     *
     * @mbggenerated
     */
    private Integer recentWinCount;

    /**
     * 字段: god_plan_issue.play_show_name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 显示名称
     *
     * @mbggenerated
     */
    private String playShowName;

    /**
     * 字段: god_plan_issue.plan_type_index<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 计划索引
     *
     * @mbggenerated
     */
    private Integer planTypeIndex;

    /**
     * 字段: god_plan_issue.plan_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 计划Id
     *
     * @mbggenerated
     */
    private Long planId;

    /**
     * 字段: god_plan_issue.is_delete<br/>
     * 必填: true<br/>
     * 缺省: b'0'<br/>
     * 长度: 1<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * 字段: god_plan_issue.create_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 字段: god_plan_issue.update_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table god_plan_issue
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return god_plan_issue.id: id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 字段: god_plan_issue.id<br/>
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
     * @return god_plan_issue.issue: 期号
     *
     * @mbggenerated
     */
    public String getIssue() {
        return issue;
    }

    /**
     * 字段: god_plan_issue.issue<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 255<br/>
     * 说明: 期号
     *
     * @mbggenerated
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * @return god_plan_issue.god_id: 大神id（即god_plan_play中id）
     *
     * @mbggenerated
     */
    public Integer getGodId() {
        return godId;
    }

    /**
     * 字段: god_plan_issue.god_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 大神id（即god_plan_play中id）
     *
     * @mbggenerated
     */
    public void setGodId(Integer godId) {
        this.godId = godId;
    }

    /**
     * @return god_plan_issue.bet_number: 投注号码
     *
     * @mbggenerated
     */
    public String getBetNumber() {
        return betNumber;
    }

    /**
     * 字段: god_plan_issue.bet_number<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 投注号码
     *
     * @mbggenerated
     */
    public void setBetNumber(String betNumber) {
        this.betNumber = betNumber;
    }

    /**
     * @return god_plan_issue.lottery_id: 彩种Id
     *
     * @mbggenerated
     */
    public Integer getLotteryId() {
        return lotteryId;
    }

    /**
     * 字段: god_plan_issue.lottery_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 彩种Id
     *
     * @mbggenerated
     */
    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    /**
     * @return god_plan_issue.play_tag_id: 玩法Id
     *
     * @mbggenerated
     */
    public Integer getPlayTagId() {
        return playTagId;
    }

    /**
     * 字段: god_plan_issue.play_tag_id<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 玩法Id
     *
     * @mbggenerated
     */
    public void setPlayTagId(Integer playTagId) {
        this.playTagId = playTagId;
    }

    /**
     * @return god_plan_issue.setting_id: 玩法配置id
     *
     * @mbggenerated
     */
    public Integer getSettingId() {
        return settingId;
    }

    /**
     * 字段: god_plan_issue.setting_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 玩法配置id
     *
     * @mbggenerated
     */
    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    /**
     * @return god_plan_issue.play_name: 玩法名称
     *
     * @mbggenerated
     */
    public String getPlayName() {
        return playName;
    }

    /**
     * 字段: god_plan_issue.play_name<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 玩法名称
     *
     * @mbggenerated
     */
    public void setPlayName(String playName) {
        this.playName = playName;
    }

    /**
     * @return god_plan_issue.number: 开奖号码
     *
     * @mbggenerated
     */
    public String getNumber() {
        return number;
    }

    /**
     * 字段: god_plan_issue.number<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 开奖号码
     *
     * @mbggenerated
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return god_plan_issue.status: 状态（0预推，1待开奖，2已开奖）
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 字段: god_plan_issue.status<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 状态（0预推，1待开奖，2已开奖）
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return god_plan_issue.tb_status: 状态：中奖 | 未中奖 | 等待开奖
     *
     * @mbggenerated
     */
    public String getTbStatus() {
        return tbStatus;
    }

    /**
     * 字段: god_plan_issue.tb_status<br/>
     * 必填: true<br/>
     * 缺省: WAIT<br/>
     * 长度: 255<br/>
     * 说明: 状态：中奖 | 未中奖 | 等待开奖
     *
     * @mbggenerated
     */
    public void setTbStatus(String tbStatus) {
        this.tbStatus = tbStatus;
    }

    /**
     * @return god_plan_issue.plan_type: 计划类型（1期，2期，3期）
     *
     * @mbggenerated
     */
    public Integer getPlanType() {
        return planType;
    }

    /**
     * 字段: god_plan_issue.plan_type<br/>
     * 必填: false<br/>
     * 缺省: 1<br/>
     * 长度: 10<br/>
     * 说明: 计划类型（1期，2期，3期）
     *
     * @mbggenerated
     */
    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    /**
     * @return god_plan_issue.ideal_time: 开奖时间
     *
     * @mbggenerated
     */
    public Date getIdealTime() {
        return idealTime;
    }

    /**
     * 字段: god_plan_issue.ideal_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 开奖时间
     *
     * @mbggenerated
     */
    public void setIdealTime(Date idealTime) {
        this.idealTime = idealTime;
    }

    /**
     * @return god_plan_issue.bet_count: 投注注数
     *
     * @mbggenerated
     */
    public Integer getBetCount() {
        return betCount;
    }

    /**
     * 字段: god_plan_issue.bet_count<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 投注注数
     *
     * @mbggenerated
     */
    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

    /**
     * @return god_plan_issue.single_money: 
     *
     * @mbggenerated
     */
    public BigDecimal getSingleMoney() {
        return singleMoney;
    }

    /**
     * 字段: god_plan_issue.single_money<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    public void setSingleMoney(BigDecimal singleMoney) {
        this.singleMoney = singleMoney;
    }

    /**
     * @return god_plan_issue.reward_amount: 大神打赏总金额
     *
     * @mbggenerated
     */
    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    /**
     * 字段: god_plan_issue.reward_amount<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 大神打赏总金额
     *
     * @mbggenerated
     */
    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    /**
     * @return god_plan_issue.recent_win_count: 中奖数
     *
     * @mbggenerated
     */
    public Integer getRecentWinCount() {
        return recentWinCount;
    }

    /**
     * 字段: god_plan_issue.recent_win_count<br/>
     * 必填: true<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 中奖数
     *
     * @mbggenerated
     */
    public void setRecentWinCount(Integer recentWinCount) {
        this.recentWinCount = recentWinCount;
    }

    /**
     * @return god_plan_issue.play_show_name: 显示名称
     *
     * @mbggenerated
     */
    public String getPlayShowName() {
        return playShowName;
    }

    /**
     * 字段: god_plan_issue.play_show_name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 显示名称
     *
     * @mbggenerated
     */
    public void setPlayShowName(String playShowName) {
        this.playShowName = playShowName;
    }

    /**
     * @return god_plan_issue.plan_type_index: 计划索引
     *
     * @mbggenerated
     */
    public Integer getPlanTypeIndex() {
        return planTypeIndex;
    }

    /**
     * 字段: god_plan_issue.plan_type_index<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 计划索引
     *
     * @mbggenerated
     */
    public void setPlanTypeIndex(Integer planTypeIndex) {
        this.planTypeIndex = planTypeIndex;
    }

    /**
     * @return god_plan_issue.plan_id: 计划Id
     *
     * @mbggenerated
     */
    public Long getPlanId() {
        return planId;
    }

    /**
     * 字段: god_plan_issue.plan_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 计划Id
     *
     * @mbggenerated
     */
    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    /**
     * @return god_plan_issue.is_delete: 是否删除
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 字段: god_plan_issue.is_delete<br/>
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
     * @return god_plan_issue.create_time: 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 字段: god_plan_issue.create_time<br/>
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
     * @return god_plan_issue.update_time: 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 字段: god_plan_issue.update_time<br/>
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
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table god_plan_issue
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
        GodPlanIssue other = (GodPlanIssue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
            && (this.getGodId() == null ? other.getGodId() == null : this.getGodId().equals(other.getGodId()))
            && (this.getBetNumber() == null ? other.getBetNumber() == null : this.getBetNumber().equals(other.getBetNumber()))
            && (this.getLotteryId() == null ? other.getLotteryId() == null : this.getLotteryId().equals(other.getLotteryId()))
            && (this.getPlayTagId() == null ? other.getPlayTagId() == null : this.getPlayTagId().equals(other.getPlayTagId()))
            && (this.getSettingId() == null ? other.getSettingId() == null : this.getSettingId().equals(other.getSettingId()))
            && (this.getPlayName() == null ? other.getPlayName() == null : this.getPlayName().equals(other.getPlayName()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTbStatus() == null ? other.getTbStatus() == null : this.getTbStatus().equals(other.getTbStatus()))
            && (this.getPlanType() == null ? other.getPlanType() == null : this.getPlanType().equals(other.getPlanType()))
            && (this.getIdealTime() == null ? other.getIdealTime() == null : this.getIdealTime().equals(other.getIdealTime()))
            && (this.getBetCount() == null ? other.getBetCount() == null : this.getBetCount().equals(other.getBetCount()))
            && (this.getSingleMoney() == null ? other.getSingleMoney() == null : this.getSingleMoney().equals(other.getSingleMoney()))
            && (this.getRewardAmount() == null ? other.getRewardAmount() == null : this.getRewardAmount().equals(other.getRewardAmount()))
            && (this.getRecentWinCount() == null ? other.getRecentWinCount() == null : this.getRecentWinCount().equals(other.getRecentWinCount()))
            && (this.getPlayShowName() == null ? other.getPlayShowName() == null : this.getPlayShowName().equals(other.getPlayShowName()))
            && (this.getPlanTypeIndex() == null ? other.getPlanTypeIndex() == null : this.getPlanTypeIndex().equals(other.getPlanTypeIndex()))
            && (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table god_plan_issue
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
        result = prime * result + ((getGodId() == null) ? 0 : getGodId().hashCode());
        result = prime * result + ((getBetNumber() == null) ? 0 : getBetNumber().hashCode());
        result = prime * result + ((getLotteryId() == null) ? 0 : getLotteryId().hashCode());
        result = prime * result + ((getPlayTagId() == null) ? 0 : getPlayTagId().hashCode());
        result = prime * result + ((getSettingId() == null) ? 0 : getSettingId().hashCode());
        result = prime * result + ((getPlayName() == null) ? 0 : getPlayName().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTbStatus() == null) ? 0 : getTbStatus().hashCode());
        result = prime * result + ((getPlanType() == null) ? 0 : getPlanType().hashCode());
        result = prime * result + ((getIdealTime() == null) ? 0 : getIdealTime().hashCode());
        result = prime * result + ((getBetCount() == null) ? 0 : getBetCount().hashCode());
        result = prime * result + ((getSingleMoney() == null) ? 0 : getSingleMoney().hashCode());
        result = prime * result + ((getRewardAmount() == null) ? 0 : getRewardAmount().hashCode());
        result = prime * result + ((getRecentWinCount() == null) ? 0 : getRecentWinCount().hashCode());
        result = prime * result + ((getPlayShowName() == null) ? 0 : getPlayShowName().hashCode());
        result = prime * result + ((getPlanTypeIndex() == null) ? 0 : getPlanTypeIndex().hashCode());
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table god_plan_issue
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
        sb.append(", issue=").append(issue);
        sb.append(", godId=").append(godId);
        sb.append(", betNumber=").append(betNumber);
        sb.append(", lotteryId=").append(lotteryId);
        sb.append(", playTagId=").append(playTagId);
        sb.append(", settingId=").append(settingId);
        sb.append(", playName=").append(playName);
        sb.append(", number=").append(number);
        sb.append(", status=").append(status);
        sb.append(", tbStatus=").append(tbStatus);
        sb.append(", planType=").append(planType);
        sb.append(", idealTime=").append(idealTime);
        sb.append(", betCount=").append(betCount);
        sb.append(", singleMoney=").append(singleMoney);
        sb.append(", rewardAmount=").append(rewardAmount);
        sb.append(", recentWinCount=").append(recentWinCount);
        sb.append(", playShowName=").append(playShowName);
        sb.append(", planTypeIndex=").append(planTypeIndex);
        sb.append(", planId=").append(planId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}