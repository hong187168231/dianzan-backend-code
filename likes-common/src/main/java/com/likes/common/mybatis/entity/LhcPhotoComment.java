package com.likes.common.mybatis.entity;

import java.io.Serializable;

public class LhcPhotoComment implements Serializable {
    /**
     * 字段: lhc_photo_comment.id<br/>
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
     * 字段: lhc_photo_comment.photoname<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 128<br/>
     * 说明: 图片名
     *
     * @mbggenerated
     */
    private String photoname;

    /**
     * 字段: lhc_photo_comment.photoid<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 图片id
     *
     * @mbggenerated
     */
    private Integer photoid;

    /**
     * 字段: lhc_photo_comment.name<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 128<br/>
     * 说明: 用户名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 字段: lhc_photo_comment.icon<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 用户头像
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 字段: lhc_photo_comment.content<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 评论内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 字段: lhc_photo_comment.time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 24<br/>
     * 说明: 评论时间
     *
     * @mbggenerated
     */
    private String time;

    /**
     * 字段: lhc_photo_comment.is_delete<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    private Integer isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lhc_photo_comment
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return lhc_photo_comment.id: 
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 字段: lhc_photo_comment.id<br/>
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
     * @return lhc_photo_comment.photoname: 图片名
     *
     * @mbggenerated
     */
    public String getPhotoname() {
        return photoname;
    }

    /**
     * 字段: lhc_photo_comment.photoname<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 128<br/>
     * 说明: 图片名
     *
     * @mbggenerated
     */
    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    /**
     * @return lhc_photo_comment.photoid: 图片id
     *
     * @mbggenerated
     */
    public Integer getPhotoid() {
        return photoid;
    }

    /**
     * 字段: lhc_photo_comment.photoid<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 图片id
     *
     * @mbggenerated
     */
    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    /**
     * @return lhc_photo_comment.name: 用户名
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 字段: lhc_photo_comment.name<br/>
     * 必填: true<br/>
     * 缺省: <br/>
     * 长度: 128<br/>
     * 说明: 用户名
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return lhc_photo_comment.icon: 用户头像
     *
     * @mbggenerated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 字段: lhc_photo_comment.icon<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 用户头像
     *
     * @mbggenerated
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return lhc_photo_comment.content: 评论内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 字段: lhc_photo_comment.content<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 256<br/>
     * 说明: 评论内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return lhc_photo_comment.time: 评论时间
     *
     * @mbggenerated
     */
    public String getTime() {
        return time;
    }

    /**
     * 字段: lhc_photo_comment.time<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 24<br/>
     * 说明: 评论时间
     *
     * @mbggenerated
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return lhc_photo_comment.is_delete: 是否删除
     *
     * @mbggenerated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 字段: lhc_photo_comment.is_delete<br/>
     * 必填: false<br/>
     * 缺省: 0<br/>
     * 长度: 10<br/>
     * 说明: 是否删除
     *
     * @mbggenerated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lhc_photo_comment
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
        LhcPhotoComment other = (LhcPhotoComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPhotoname() == null ? other.getPhotoname() == null : this.getPhotoname().equals(other.getPhotoname()))
            && (this.getPhotoid() == null ? other.getPhotoid() == null : this.getPhotoid().equals(other.getPhotoid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lhc_photo_comment
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPhotoname() == null) ? 0 : getPhotoname().hashCode());
        result = prime * result + ((getPhotoid() == null) ? 0 : getPhotoid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lhc_photo_comment
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
        sb.append(", photoname=").append(photoname);
        sb.append(", photoid=").append(photoid);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", content=").append(content);
        sb.append(", time=").append(time);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}