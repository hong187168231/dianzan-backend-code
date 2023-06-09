package com.likes.common.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DbBetOrder implements Serializable {
    /**
     * 字段: db_bet_order.id<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 字段: db_bet_order.seq_no<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 游戏序号
     *
     * @mbggenerated
     */
    private Long seqNo;

    /**
     * 字段: db_bet_order.player_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 25<br/>
     * 说明: 玩家账号
     *
     * @mbggenerated
     */
    private String playerId;

    /**
     * 字段: db_bet_order.game_date<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 游戏时间
     *
     * @mbggenerated
     */
    private Date gameDate;

    /**
     * 字段: db_bet_order.g_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 游戏型态
     *
     * @mbggenerated
     */
    private Integer gType;

    /**
     * 字段: db_bet_order.m_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 机台类型
     *
     * @mbggenerated
     */
    private Integer mType;

    /**
     * 字段: db_bet_order.room_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 游戏区域
     *
     * @mbggenerated
     */
    private Integer roomType;

    /**
     * 字段: db_bet_order.currency<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 3<br/>
     * 说明: 货币
     *
     * @mbggenerated
     */
    private String currency;

    /**
     * 字段: db_bet_order.bet<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 押注金额
     *
     * @mbggenerated
     */
    private BigDecimal bet;

    /**
     * 字段: db_bet_order.win<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 游戏赢分
     *
     * @mbggenerated
     */
    private BigDecimal win;

    /**
     * 字段: db_bet_order.total<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 总输赢
     *
     * @mbggenerated
     */
    private BigDecimal total;

    /**
     * 字段: db_bet_order.denom<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 投注面值
     *
     * @mbggenerated
     */
    private BigDecimal denom;

    /**
     * 字段: db_bet_order.before_balance<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 进场金额
     *
     * @mbggenerated
     */
    private BigDecimal beforeBalance;

    /**
     * 字段: db_bet_order.after_balance<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 离场金额
     *
     * @mbggenerated
     */
    private BigDecimal afterBalance;

    /**
     * 字段: db_bet_order.last_modify_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 最后修改时间
     *
     * @mbggenerated
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+7"
    )
    private Date lastModifyTime;

    /**
     * 字段: db_bet_order.player_ip<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 50<br/>
     * 说明: 玩家登入 IP
     *
     * @mbggenerated
     */
    private String playerIp;

    /**
     * 字段: db_bet_order.client_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 玩家从网页或行动装置登入
     *
     * @mbggenerated
     */
    private String clientType;

    /**
     * 字段: db_bet_order.is_handle<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    private Integer isHandle;

    /**
     * 字段: db_bet_order.game_name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 游戏名称
     *
     * @mbggenerated
     */
    private String gameName;

    /**
     * 字段: db_bet_order.member_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 用户ID
     *
     * @mbggenerated
     */
    private Long memberId;

    /**
     * 字段: db_bet_order.create_time<br/>
     * 必填: false<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+7"
    )
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table db_bet_order
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return db_bet_order.id: 
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 字段: db_bet_order.id<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return db_bet_order.seq_no: 游戏序号
     *
     * @mbggenerated
     */
    public Long getSeqNo() {
        return seqNo;
    }

    /**
     * 字段: db_bet_order.seq_no<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 游戏序号
     *
     * @mbggenerated
     */
    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * @return db_bet_order.player_id: 玩家账号
     *
     * @mbggenerated
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * 字段: db_bet_order.player_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 25<br/>
     * 说明: 玩家账号
     *
     * @mbggenerated
     */
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     * @return db_bet_order.game_date: 游戏时间
     *
     * @mbggenerated
     */
    public Date getGameDate() {
        return gameDate;
    }

    /**
     * 字段: db_bet_order.game_date<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 游戏时间
     *
     * @mbggenerated
     */
    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    /**
     * @return db_bet_order.g_type: 游戏型态
     *
     * @mbggenerated
     */
    public Integer getgType() {
        return gType;
    }

    /**
     * 字段: db_bet_order.g_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 游戏型态
     *
     * @mbggenerated
     */
    public void setgType(Integer gType) {
        this.gType = gType;
    }

    /**
     * @return db_bet_order.m_type: 机台类型
     *
     * @mbggenerated
     */
    public Integer getmType() {
        return mType;
    }

    /**
     * 字段: db_bet_order.m_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 机台类型
     *
     * @mbggenerated
     */
    public void setmType(Integer mType) {
        this.mType = mType;
    }

    /**
     * @return db_bet_order.room_type: 游戏区域
     *
     * @mbggenerated
     */
    public Integer getRoomType() {
        return roomType;
    }

    /**
     * 字段: db_bet_order.room_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 游戏区域
     *
     * @mbggenerated
     */
    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    /**
     * @return db_bet_order.currency: 货币
     *
     * @mbggenerated
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 字段: db_bet_order.currency<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 3<br/>
     * 说明: 货币
     *
     * @mbggenerated
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return db_bet_order.bet: 押注金额
     *
     * @mbggenerated
     */
    public BigDecimal getBet() {
        return bet;
    }

    /**
     * 字段: db_bet_order.bet<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 押注金额
     *
     * @mbggenerated
     */
    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }

    /**
     * @return db_bet_order.win: 游戏赢分
     *
     * @mbggenerated
     */
    public BigDecimal getWin() {
        return win;
    }

    /**
     * 字段: db_bet_order.win<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 游戏赢分
     *
     * @mbggenerated
     */
    public void setWin(BigDecimal win) {
        this.win = win;
    }

    /**
     * @return db_bet_order.total: 总输赢
     *
     * @mbggenerated
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * 字段: db_bet_order.total<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 总输赢
     *
     * @mbggenerated
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return db_bet_order.denom: 投注面值
     *
     * @mbggenerated
     */
    public BigDecimal getDenom() {
        return denom;
    }

    /**
     * 字段: db_bet_order.denom<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 投注面值
     *
     * @mbggenerated
     */
    public void setDenom(BigDecimal denom) {
        this.denom = denom;
    }

    /**
     * @return db_bet_order.before_balance: 进场金额
     *
     * @mbggenerated
     */
    public BigDecimal getBeforeBalance() {
        return beforeBalance;
    }

    /**
     * 字段: db_bet_order.before_balance<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 进场金额
     *
     * @mbggenerated
     */
    public void setBeforeBalance(BigDecimal beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    /**
     * @return db_bet_order.after_balance: 离场金额
     *
     * @mbggenerated
     */
    public BigDecimal getAfterBalance() {
        return afterBalance;
    }

    /**
     * 字段: db_bet_order.after_balance<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 离场金额
     *
     * @mbggenerated
     */
    public void setAfterBalance(BigDecimal afterBalance) {
        this.afterBalance = afterBalance;
    }

    /**
     * @return db_bet_order.last_modify_time: 最后修改时间
     *
     * @mbggenerated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 字段: db_bet_order.last_modify_time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 最后修改时间
     *
     * @mbggenerated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * @return db_bet_order.player_ip: 玩家登入 IP
     *
     * @mbggenerated
     */
    public String getPlayerIp() {
        return playerIp;
    }

    /**
     * 字段: db_bet_order.player_ip<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 50<br/>
     * 说明: 玩家登入 IP
     *
     * @mbggenerated
     */
    public void setPlayerIp(String playerIp) {
        this.playerIp = playerIp;
    }

    /**
     * @return db_bet_order.client_type: 玩家从网页或行动装置登入
     *
     * @mbggenerated
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * 字段: db_bet_order.client_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 20<br/>
     * 说明: 玩家从网页或行动装置登入
     *
     * @mbggenerated
     */
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    /**
     * @return db_bet_order.is_handle: 
     *
     * @mbggenerated
     */
    public Integer getIsHandle() {
        return isHandle;
    }

    /**
     * 字段: db_bet_order.is_handle<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 
     *
     * @mbggenerated
     */
    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    /**
     * @return db_bet_order.game_name: 游戏名称
     *
     * @mbggenerated
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * 字段: db_bet_order.game_name<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 游戏名称
     *
     * @mbggenerated
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * @return db_bet_order.member_id: 用户ID
     *
     * @mbggenerated
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 字段: db_bet_order.member_id<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 用户ID
     *
     * @mbggenerated
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * @return db_bet_order.create_time: 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 字段: db_bet_order.create_time<br/>
     * 必填: false<br/>
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
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_bet_order
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
        DbBetOrder other = (DbBetOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSeqNo() == null ? other.getSeqNo() == null : this.getSeqNo().equals(other.getSeqNo()))
            && (this.getPlayerId() == null ? other.getPlayerId() == null : this.getPlayerId().equals(other.getPlayerId()))
            && (this.getGameDate() == null ? other.getGameDate() == null : this.getGameDate().equals(other.getGameDate()))
            && (this.getgType() == null ? other.getgType() == null : this.getgType().equals(other.getgType()))
            && (this.getmType() == null ? other.getmType() == null : this.getmType().equals(other.getmType()))
            && (this.getRoomType() == null ? other.getRoomType() == null : this.getRoomType().equals(other.getRoomType()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getBet() == null ? other.getBet() == null : this.getBet().equals(other.getBet()))
            && (this.getWin() == null ? other.getWin() == null : this.getWin().equals(other.getWin()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getDenom() == null ? other.getDenom() == null : this.getDenom().equals(other.getDenom()))
            && (this.getBeforeBalance() == null ? other.getBeforeBalance() == null : this.getBeforeBalance().equals(other.getBeforeBalance()))
            && (this.getAfterBalance() == null ? other.getAfterBalance() == null : this.getAfterBalance().equals(other.getAfterBalance()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getPlayerIp() == null ? other.getPlayerIp() == null : this.getPlayerIp().equals(other.getPlayerIp()))
            && (this.getClientType() == null ? other.getClientType() == null : this.getClientType().equals(other.getClientType()))
            && (this.getIsHandle() == null ? other.getIsHandle() == null : this.getIsHandle().equals(other.getIsHandle()))
            && (this.getGameName() == null ? other.getGameName() == null : this.getGameName().equals(other.getGameName()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_bet_order
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSeqNo() == null) ? 0 : getSeqNo().hashCode());
        result = prime * result + ((getPlayerId() == null) ? 0 : getPlayerId().hashCode());
        result = prime * result + ((getGameDate() == null) ? 0 : getGameDate().hashCode());
        result = prime * result + ((getgType() == null) ? 0 : getgType().hashCode());
        result = prime * result + ((getmType() == null) ? 0 : getmType().hashCode());
        result = prime * result + ((getRoomType() == null) ? 0 : getRoomType().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getBet() == null) ? 0 : getBet().hashCode());
        result = prime * result + ((getWin() == null) ? 0 : getWin().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getDenom() == null) ? 0 : getDenom().hashCode());
        result = prime * result + ((getBeforeBalance() == null) ? 0 : getBeforeBalance().hashCode());
        result = prime * result + ((getAfterBalance() == null) ? 0 : getAfterBalance().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getPlayerIp() == null) ? 0 : getPlayerIp().hashCode());
        result = prime * result + ((getClientType() == null) ? 0 : getClientType().hashCode());
        result = prime * result + ((getIsHandle() == null) ? 0 : getIsHandle().hashCode());
        result = prime * result + ((getGameName() == null) ? 0 : getGameName().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_bet_order
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
        sb.append(", seqNo=").append(seqNo);
        sb.append(", playerId=").append(playerId);
        sb.append(", gameDate=").append(gameDate);
        sb.append(", gType=").append(gType);
        sb.append(", mType=").append(mType);
        sb.append(", roomType=").append(roomType);
        sb.append(", currency=").append(currency);
        sb.append(", bet=").append(bet);
        sb.append(", win=").append(win);
        sb.append(", total=").append(total);
        sb.append(", denom=").append(denom);
        sb.append(", beforeBalance=").append(beforeBalance);
        sb.append(", afterBalance=").append(afterBalance);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", playerIp=").append(playerIp);
        sb.append(", clientType=").append(clientType);
        sb.append(", isHandle=").append(isHandle);
        sb.append(", gameName=").append(gameName);
        sb.append(", memberId=").append(memberId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}