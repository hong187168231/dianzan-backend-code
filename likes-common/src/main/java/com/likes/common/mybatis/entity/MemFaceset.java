package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class MemFaceset implements Serializable {
    /**
     * 字段: mem_faceset.faceid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 美颜id
     *
     * @mbggenerated
     */
    private Long faceid;

    /**
     * 字段: mem_faceset.accno<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 会员标识号
     *
     * @mbggenerated
     */
    private String accno;

    /**
     * 字段: mem_faceset.beauty<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 500<br/>
     * 说明: 美颜参数设置 （json）
     *
     * @mbggenerated
     */
    private String beauty;

    /**
     * 字段: mem_faceset.filter<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 500<br/>
     * 说明: 滤镜参数设置（json）
     *
     * @mbggenerated
     */
    private String filter;

    /**
     * 字段: mem_faceset.is_delete<br/>
     * 必填: true<br/>
     * 缺省: b'0'<br/>
     * 长度: 1<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * 字段: mem_faceset.create_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 字段: mem_faceset.create_time<br/>
     * 必填: true<br/>
     * 缺省: CURRENT_TIMESTAMP<br/>
     * 长度: 19<br/>
     * 说明: 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 字段: mem_faceset.update_user<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 最后修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 字段: mem_faceset.update_time<br/>
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
     * This field corresponds to the database table mem_faceset
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return mem_faceset.faceid: 美颜id
     *
     * @mbggenerated
     */
    public Long getFaceid() {
        return faceid;
    }

    /**
     * 字段: mem_faceset.faceid<br/>
     * 主键: 自动增长<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 19<br/>
     * 说明: 美颜id
     *
     * @mbggenerated
     */
    public void setFaceid(Long faceid) {
        this.faceid = faceid;
    }

    /**
     * @return mem_faceset.accno: 会员标识号
     *
     * @mbggenerated
     */
    public String getAccno() {
        return accno;
    }

    /**
     * 字段: mem_faceset.accno<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 32<br/>
     * 说明: 会员标识号
     *
     * @mbggenerated
     */
    public void setAccno(String accno) {
        this.accno = accno;
    }

    /**
     * @return mem_faceset.beauty: 美颜参数设置 （json）
     *
     * @mbggenerated
     */
    public String getBeauty() {
        return beauty;
    }

    /**
     * 字段: mem_faceset.beauty<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 500<br/>
     * 说明: 美颜参数设置 （json）
     *
     * @mbggenerated
     */
    public void setBeauty(String beauty) {
        this.beauty = beauty;
    }

    /**
     * @return mem_faceset.filter: 滤镜参数设置（json）
     *
     * @mbggenerated
     */
    public String getFilter() {
        return filter;
    }

    /**
     * 字段: mem_faceset.filter<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 500<br/>
     * 说明: 滤镜参数设置（json）
     *
     * @mbggenerated
     */
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /**
     * @return mem_faceset.is_delete: 是否删除
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 字段: mem_faceset.is_delete<br/>
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
     * @return mem_faceset.create_user: 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 字段: mem_faceset.create_user<br/>
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
     * @return mem_faceset.create_time: 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 字段: mem_faceset.create_time<br/>
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
     * @return mem_faceset.update_user: 最后修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 字段: mem_faceset.update_user<br/>
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
     * @return mem_faceset.update_time: 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 字段: mem_faceset.update_time<br/>
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
     * This method corresponds to the database table mem_faceset
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
        MemFaceset other = (MemFaceset) that;
        return (this.getFaceid() == null ? other.getFaceid() == null : this.getFaceid().equals(other.getFaceid()))
            && (this.getAccno() == null ? other.getAccno() == null : this.getAccno().equals(other.getAccno()))
            && (this.getBeauty() == null ? other.getBeauty() == null : this.getBeauty().equals(other.getBeauty()))
            && (this.getFilter() == null ? other.getFilter() == null : this.getFilter().equals(other.getFilter()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_faceset
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFaceid() == null) ? 0 : getFaceid().hashCode());
        result = prime * result + ((getAccno() == null) ? 0 : getAccno().hashCode());
        result = prime * result + ((getBeauty() == null) ? 0 : getBeauty().hashCode());
        result = prime * result + ((getFilter() == null) ? 0 : getFilter().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_faceset
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", faceid=").append(faceid);
        sb.append(", accno=").append(accno);
        sb.append(", beauty=").append(beauty);
        sb.append(", filter=").append(filter);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}