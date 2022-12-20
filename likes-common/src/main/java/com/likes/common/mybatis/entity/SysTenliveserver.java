package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class SysTenliveserver implements Serializable {
    /**
     * 字段: sys_tenliveserver.tliveid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 直播服务器id
     *
     * @mbggenerated
     */
    private Long tliveid;

    /**
     * 字段: sys_tenliveserver.servername<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 服务器名称
     *
     * @mbggenerated
     */
    private String servername;

    /**
     * 字段: sys_tenliveserver.serverurl<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 400<br/>
     * 说明: 服务器地址
     *
     * @mbggenerated
     */
    private String serverurl;

    /**
     * 字段: sys_tenliveserver.weight<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 服务器权重
     *
     * @mbggenerated
     */
    private Integer weight;

    /**
     * 字段: sys_tenliveserver.servertype<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1<br/>
     * 说明: 服务类型  1:  推流域名 2: 播放域名
     *
     * @mbggenerated
     */
    private Integer servertype;

    /**
     * 字段: sys_tenliveserver.ptliveid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 所属推流服务器id
     *
     * @mbggenerated
     */
    private Long ptliveid;

    /**
     * 字段: sys_tenliveserver.region<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 服务器所在区域名称
     *
     * @mbggenerated
     */
    private String region;

    /**
     * 字段: sys_tenliveserver.primarykey<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 鉴权主key
     *
     * @mbggenerated
     */
    private String primarykey;

    /**
     * 字段: sys_tenliveserver.backupkey<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 鉴权备用key
     *
     * @mbggenerated
     */
    private String backupkey;

    /**
     * 字段: sys_tenliveserver.status<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1<br/>
     * 说明: 启用状态0启用9未启用
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 字段: sys_tenliveserver.is_delete<br/>
     * 必填: true<br/>
     * 缺省: b'0'<br/>
     * 长度: 1<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * 字段: sys_tenliveserver.create_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 字段: sys_tenliveserver.create_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 字段: sys_tenliveserver.update_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 最后修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 字段: sys_tenliveserver.update_time<br/>
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
     * This field corresponds to the database table sys_tenliveserver
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return sys_tenliveserver.tliveid: 直播服务器id
     *
     * @mbggenerated
     */
    public Long getTliveid() {
        return tliveid;
    }

    /**
     * 字段: sys_tenliveserver.tliveid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 直播服务器id
     *
     * @mbggenerated
     */
    public void setTliveid(Long tliveid) {
        this.tliveid = tliveid;
    }

    /**
     * @return sys_tenliveserver.servername: 服务器名称
     *
     * @mbggenerated
     */
    public String getServername() {
        return servername;
    }

    /**
     * 字段: sys_tenliveserver.servername<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 服务器名称
     *
     * @mbggenerated
     */
    public void setServername(String servername) {
        this.servername = servername;
    }

    /**
     * @return sys_tenliveserver.serverurl: 服务器地址
     *
     * @mbggenerated
     */
    public String getServerurl() {
        return serverurl;
    }

    /**
     * 字段: sys_tenliveserver.serverurl<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 400<br/>
     * 说明: 服务器地址
     *
     * @mbggenerated
     */
    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }

    /**
     * @return sys_tenliveserver.weight: 服务器权重
     *
     * @mbggenerated
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 字段: sys_tenliveserver.weight<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 服务器权重
     *
     * @mbggenerated
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return sys_tenliveserver.servertype: 服务类型  1:  推流域名 2: 播放域名
     *
     * @mbggenerated
     */
    public Integer getServertype() {
        return servertype;
    }

    /**
     * 字段: sys_tenliveserver.servertype<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1<br/>
     * 说明: 服务类型  1:  推流域名 2: 播放域名
     *
     * @mbggenerated
     */
    public void setServertype(Integer servertype) {
        this.servertype = servertype;
    }

    /**
     * @return sys_tenliveserver.ptliveid: 所属推流服务器id
     *
     * @mbggenerated
     */
    public Long getPtliveid() {
        return ptliveid;
    }

    /**
     * 字段: sys_tenliveserver.ptliveid<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 所属推流服务器id
     *
     * @mbggenerated
     */
    public void setPtliveid(Long ptliveid) {
        this.ptliveid = ptliveid;
    }

    /**
     * @return sys_tenliveserver.region: 服务器所在区域名称
     *
     * @mbggenerated
     */
    public String getRegion() {
        return region;
    }

    /**
     * 字段: sys_tenliveserver.region<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 100<br/>
     * 说明: 服务器所在区域名称
     *
     * @mbggenerated
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return sys_tenliveserver.primarykey: 鉴权主key
     *
     * @mbggenerated
     */
    public String getPrimarykey() {
        return primarykey;
    }

    /**
     * 字段: sys_tenliveserver.primarykey<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 鉴权主key
     *
     * @mbggenerated
     */
    public void setPrimarykey(String primarykey) {
        this.primarykey = primarykey;
    }

    /**
     * @return sys_tenliveserver.backupkey: 鉴权备用key
     *
     * @mbggenerated
     */
    public String getBackupkey() {
        return backupkey;
    }

    /**
     * 字段: sys_tenliveserver.backupkey<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 鉴权备用key
     *
     * @mbggenerated
     */
    public void setBackupkey(String backupkey) {
        this.backupkey = backupkey;
    }

    /**
     * @return sys_tenliveserver.status: 启用状态0启用9未启用
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 字段: sys_tenliveserver.status<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 1<br/>
     * 说明: 启用状态0启用9未启用
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return sys_tenliveserver.is_delete: 是否删除
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 字段: sys_tenliveserver.is_delete<br/>
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
     * @return sys_tenliveserver.create_user: 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 字段: sys_tenliveserver.create_user<br/>
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
     * @return sys_tenliveserver.create_time: 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 字段: sys_tenliveserver.create_time<br/>
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
     * @return sys_tenliveserver.update_user: 最后修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 字段: sys_tenliveserver.update_user<br/>
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
     * @return sys_tenliveserver.update_time: 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 字段: sys_tenliveserver.update_time<br/>
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
     * This method corresponds to the database table sys_tenliveserver
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
        SysTenliveserver other = (SysTenliveserver) that;
        return (this.getTliveid() == null ? other.getTliveid() == null : this.getTliveid().equals(other.getTliveid()))
            && (this.getServername() == null ? other.getServername() == null : this.getServername().equals(other.getServername()))
            && (this.getServerurl() == null ? other.getServerurl() == null : this.getServerurl().equals(other.getServerurl()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getServertype() == null ? other.getServertype() == null : this.getServertype().equals(other.getServertype()))
            && (this.getPtliveid() == null ? other.getPtliveid() == null : this.getPtliveid().equals(other.getPtliveid()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getPrimarykey() == null ? other.getPrimarykey() == null : this.getPrimarykey().equals(other.getPrimarykey()))
            && (this.getBackupkey() == null ? other.getBackupkey() == null : this.getBackupkey().equals(other.getBackupkey()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tenliveserver
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTliveid() == null) ? 0 : getTliveid().hashCode());
        result = prime * result + ((getServername() == null) ? 0 : getServername().hashCode());
        result = prime * result + ((getServerurl() == null) ? 0 : getServerurl().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getServertype() == null) ? 0 : getServertype().hashCode());
        result = prime * result + ((getPtliveid() == null) ? 0 : getPtliveid().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getPrimarykey() == null) ? 0 : getPrimarykey().hashCode());
        result = prime * result + ((getBackupkey() == null) ? 0 : getBackupkey().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tenliveserver
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tliveid=").append(tliveid);
        sb.append(", servername=").append(servername);
        sb.append(", serverurl=").append(serverurl);
        sb.append(", weight=").append(weight);
        sb.append(", servertype=").append(servertype);
        sb.append(", ptliveid=").append(ptliveid);
        sb.append(", region=").append(region);
        sb.append(", primarykey=").append(primarykey);
        sb.append(", backupkey=").append(backupkey);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}