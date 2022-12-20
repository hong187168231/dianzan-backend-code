package com.likes.common.mybatis.entity;

import java.io.Serializable;

public class AppVestBag implements Serializable {
    /**
     * 字段: app_vest_bag.id<br/>
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
     * 字段: app_vest_bag.share_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 分享网址
     *
     * @mbggenerated
     */
    private String shareUrl;

    /**
     * 字段: app_vest_bag.two_code<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 二维码
     *
     * @mbggenerated
     */
    private String twoCode;

    /**
     * 字段: app_vest_bag.android_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 安卓下载包
     *
     * @mbggenerated
     */
    private String androidUrl;

    /**
     * 字段: app_vest_bag.ios_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: IOS下载包
     *
     * @mbggenerated
     */
    private String iosUrl;

    /**
     * 字段: app_vest_bag.service_contract<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 服务协议
     *
     * @mbggenerated
     */
    private String serviceContract;

    /**
     * 字段: app_vest_bag.service_qq1<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 客服qq1
     *
     * @mbggenerated
     */
    private String serviceQq1;

    /**
     * 字段: app_vest_bag.service_qq2<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 客服qq2
     *
     * @mbggenerated
     */
    private String serviceQq2;

    /**
     * 字段: app_vest_bag.h5_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: h5地址
     *
     * @mbggenerated
     */
    private String h5Url;

    /**
     * 字段: app_vest_bag.app_api<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: app-api地址(运维管理)
     *
     * @mbggenerated
     */
    private String appApi;

    /**
     * 字段: app_vest_bag.web_api<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: web-api地址(运维管理)
     *
     * @mbggenerated
     */
    private String webApi;

    /**
     * 字段: app_vest_bag.fp_api<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 封盘api(运维管理)
     *
     * @mbggenerated
     */
    private String fpApi;

    /**
     * 字段: app_vest_bag.chat_websocket<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 聊天websocket(运维管理)
     *
     * @mbggenerated
     */
    private String chatWebsocket;

    /**
     * 字段: app_vest_bag.sg_websocket<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 开奖websocket(运维管理)
     *
     * @mbggenerated
     */
    private String sgWebsocket;

    /**
     * 字段: app_vest_bag.direct_kj<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 直播开奖(运维管理)
     *
     * @mbggenerated
     */
    private String directKj;

    /**
     * 字段: app_vest_bag.file_upload<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 文件上传(运维管理)
     *
     * @mbggenerated
     */
    private String fileUpload;

    /**
     * 字段: app_vest_bag.h5url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: h5地址(运维管理)
     *
     * @mbggenerated
     */
    private String h5url;

    /**
     * 字段: app_vest_bag.download_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 下载地址(运维管理)
     *
     * @mbggenerated
     */
    private String downloadUrl;

    /**
     * 字段: app_vest_bag.ios_download_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: ios下载地址(运维管理)
     *
     * @mbggenerated
     */
    private String iosDownloadUrl;

    /**
     * 字段: app_vest_bag.android_download_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: android下载地址(运维管理)
     *
     * @mbggenerated
     */
    private String androidDownloadUrl;

    /**
     * 字段: app_vest_bag.pay_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 支付地址(运维管理)
     *
     * @mbggenerated
     */
    private String payUrl;

    /**
     * 字段: app_vest_bag.bbsweb_interface<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: bbsweb接口(运维管理)
     *
     * @mbggenerated
     */
    private String bbswebInterface;

    /**
     * 字段: app_vest_bag.bbsapp_interface<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: bbsapp接口(运维管理)
     *
     * @mbggenerated
     */
    private String bbsappInterface;

    /**
     * 字段: app_vest_bag.chat_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 聊天服务器地址(运维管理)
     *
     * @mbggenerated
     */
    private String chatUrl;

    /**
     * 字段: app_vest_bag.chat_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 聊天平台类型(运维管理)
     *
     * @mbggenerated
     */
    private String chatType;

    /**
     * 字段: app_vest_bag.plat_form<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 平台类型
     *
     * @mbggenerated
     */
    private Integer platForm;

    /**
     * 字段: app_vest_bag.about_us<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 65535<br/>
     * 说明: 关于我们
     *
     * @mbggenerated
     */
    private String aboutUs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_vest_bag
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return app_vest_bag.id: 
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 字段: app_vest_bag.id<br/>
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
     * @return app_vest_bag.share_url: 分享网址
     *
     * @mbggenerated
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 字段: app_vest_bag.share_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 分享网址
     *
     * @mbggenerated
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    /**
     * @return app_vest_bag.two_code: 二维码
     *
     * @mbggenerated
     */
    public String getTwoCode() {
        return twoCode;
    }

    /**
     * 字段: app_vest_bag.two_code<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 二维码
     *
     * @mbggenerated
     */
    public void setTwoCode(String twoCode) {
        this.twoCode = twoCode;
    }

    /**
     * @return app_vest_bag.android_url: 安卓下载包
     *
     * @mbggenerated
     */
    public String getAndroidUrl() {
        return androidUrl;
    }

    /**
     * 字段: app_vest_bag.android_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 安卓下载包
     *
     * @mbggenerated
     */
    public void setAndroidUrl(String androidUrl) {
        this.androidUrl = androidUrl;
    }

    /**
     * @return app_vest_bag.ios_url: IOS下载包
     *
     * @mbggenerated
     */
    public String getIosUrl() {
        return iosUrl;
    }

    /**
     * 字段: app_vest_bag.ios_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: IOS下载包
     *
     * @mbggenerated
     */
    public void setIosUrl(String iosUrl) {
        this.iosUrl = iosUrl;
    }

    /**
     * @return app_vest_bag.service_contract: 服务协议
     *
     * @mbggenerated
     */
    public String getServiceContract() {
        return serviceContract;
    }

    /**
     * 字段: app_vest_bag.service_contract<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 服务协议
     *
     * @mbggenerated
     */
    public void setServiceContract(String serviceContract) {
        this.serviceContract = serviceContract;
    }

    /**
     * @return app_vest_bag.service_qq1: 客服qq1
     *
     * @mbggenerated
     */
    public String getServiceQq1() {
        return serviceQq1;
    }

    /**
     * 字段: app_vest_bag.service_qq1<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 客服qq1
     *
     * @mbggenerated
     */
    public void setServiceQq1(String serviceQq1) {
        this.serviceQq1 = serviceQq1;
    }

    /**
     * @return app_vest_bag.service_qq2: 客服qq2
     *
     * @mbggenerated
     */
    public String getServiceQq2() {
        return serviceQq2;
    }

    /**
     * 字段: app_vest_bag.service_qq2<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 客服qq2
     *
     * @mbggenerated
     */
    public void setServiceQq2(String serviceQq2) {
        this.serviceQq2 = serviceQq2;
    }

    /**
     * @return app_vest_bag.h5_url: h5地址
     *
     * @mbggenerated
     */
    public String getH5Url() {
        return h5Url;
    }

    /**
     * 字段: app_vest_bag.h5_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: h5地址
     *
     * @mbggenerated
     */
    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    /**
     * @return app_vest_bag.app_api: app-api地址(运维管理)
     *
     * @mbggenerated
     */
    public String getAppApi() {
        return appApi;
    }

    /**
     * 字段: app_vest_bag.app_api<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: app-api地址(运维管理)
     *
     * @mbggenerated
     */
    public void setAppApi(String appApi) {
        this.appApi = appApi;
    }

    /**
     * @return app_vest_bag.web_api: web-api地址(运维管理)
     *
     * @mbggenerated
     */
    public String getWebApi() {
        return webApi;
    }

    /**
     * 字段: app_vest_bag.web_api<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: web-api地址(运维管理)
     *
     * @mbggenerated
     */
    public void setWebApi(String webApi) {
        this.webApi = webApi;
    }

    /**
     * @return app_vest_bag.fp_api: 封盘api(运维管理)
     *
     * @mbggenerated
     */
    public String getFpApi() {
        return fpApi;
    }

    /**
     * 字段: app_vest_bag.fp_api<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 封盘api(运维管理)
     *
     * @mbggenerated
     */
    public void setFpApi(String fpApi) {
        this.fpApi = fpApi;
    }

    /**
     * @return app_vest_bag.chat_websocket: 聊天websocket(运维管理)
     *
     * @mbggenerated
     */
    public String getChatWebsocket() {
        return chatWebsocket;
    }

    /**
     * 字段: app_vest_bag.chat_websocket<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 聊天websocket(运维管理)
     *
     * @mbggenerated
     */
    public void setChatWebsocket(String chatWebsocket) {
        this.chatWebsocket = chatWebsocket;
    }

    /**
     * @return app_vest_bag.sg_websocket: 开奖websocket(运维管理)
     *
     * @mbggenerated
     */
    public String getSgWebsocket() {
        return sgWebsocket;
    }

    /**
     * 字段: app_vest_bag.sg_websocket<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 开奖websocket(运维管理)
     *
     * @mbggenerated
     */
    public void setSgWebsocket(String sgWebsocket) {
        this.sgWebsocket = sgWebsocket;
    }

    /**
     * @return app_vest_bag.direct_kj: 直播开奖(运维管理)
     *
     * @mbggenerated
     */
    public String getDirectKj() {
        return directKj;
    }

    /**
     * 字段: app_vest_bag.direct_kj<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 直播开奖(运维管理)
     *
     * @mbggenerated
     */
    public void setDirectKj(String directKj) {
        this.directKj = directKj;
    }

    /**
     * @return app_vest_bag.file_upload: 文件上传(运维管理)
     *
     * @mbggenerated
     */
    public String getFileUpload() {
        return fileUpload;
    }

    /**
     * 字段: app_vest_bag.file_upload<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 文件上传(运维管理)
     *
     * @mbggenerated
     */
    public void setFileUpload(String fileUpload) {
        this.fileUpload = fileUpload;
    }

    /**
     * @return app_vest_bag.h5url: h5地址(运维管理)
     *
     * @mbggenerated
     */
    public String getH5url() {
        return h5url;
    }

    /**
     * 字段: app_vest_bag.h5url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: h5地址(运维管理)
     *
     * @mbggenerated
     */
    public void setH5url(String h5url) {
        this.h5url = h5url;
    }

    /**
     * @return app_vest_bag.download_url: 下载地址(运维管理)
     *
     * @mbggenerated
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * 字段: app_vest_bag.download_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 下载地址(运维管理)
     *
     * @mbggenerated
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * @return app_vest_bag.ios_download_url: ios下载地址(运维管理)
     *
     * @mbggenerated
     */
    public String getIosDownloadUrl() {
        return iosDownloadUrl;
    }

    /**
     * 字段: app_vest_bag.ios_download_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: ios下载地址(运维管理)
     *
     * @mbggenerated
     */
    public void setIosDownloadUrl(String iosDownloadUrl) {
        this.iosDownloadUrl = iosDownloadUrl;
    }

    /**
     * @return app_vest_bag.android_download_url: android下载地址(运维管理)
     *
     * @mbggenerated
     */
    public String getAndroidDownloadUrl() {
        return androidDownloadUrl;
    }

    /**
     * 字段: app_vest_bag.android_download_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: android下载地址(运维管理)
     *
     * @mbggenerated
     */
    public void setAndroidDownloadUrl(String androidDownloadUrl) {
        this.androidDownloadUrl = androidDownloadUrl;
    }

    /**
     * @return app_vest_bag.pay_url: 支付地址(运维管理)
     *
     * @mbggenerated
     */
    public String getPayUrl() {
        return payUrl;
    }

    /**
     * 字段: app_vest_bag.pay_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 支付地址(运维管理)
     *
     * @mbggenerated
     */
    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    /**
     * @return app_vest_bag.bbsweb_interface: bbsweb接口(运维管理)
     *
     * @mbggenerated
     */
    public String getBbswebInterface() {
        return bbswebInterface;
    }

    /**
     * 字段: app_vest_bag.bbsweb_interface<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: bbsweb接口(运维管理)
     *
     * @mbggenerated
     */
    public void setBbswebInterface(String bbswebInterface) {
        this.bbswebInterface = bbswebInterface;
    }

    /**
     * @return app_vest_bag.bbsapp_interface: bbsapp接口(运维管理)
     *
     * @mbggenerated
     */
    public String getBbsappInterface() {
        return bbsappInterface;
    }

    /**
     * 字段: app_vest_bag.bbsapp_interface<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: bbsapp接口(运维管理)
     *
     * @mbggenerated
     */
    public void setBbsappInterface(String bbsappInterface) {
        this.bbsappInterface = bbsappInterface;
    }

    /**
     * @return app_vest_bag.chat_url: 聊天服务器地址(运维管理)
     *
     * @mbggenerated
     */
    public String getChatUrl() {
        return chatUrl;
    }

    /**
     * 字段: app_vest_bag.chat_url<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 聊天服务器地址(运维管理)
     *
     * @mbggenerated
     */
    public void setChatUrl(String chatUrl) {
        this.chatUrl = chatUrl;
    }

    /**
     * @return app_vest_bag.chat_type: 聊天平台类型(运维管理)
     *
     * @mbggenerated
     */
    public String getChatType() {
        return chatType;
    }

    /**
     * 字段: app_vest_bag.chat_type<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 255<br/>
     * 说明: 聊天平台类型(运维管理)
     *
     * @mbggenerated
     */
    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    /**
     * @return app_vest_bag.plat_form: 平台类型
     *
     * @mbggenerated
     */
    public Integer getPlatForm() {
        return platForm;
    }

    /**
     * 字段: app_vest_bag.plat_form<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 10<br/>
     * 说明: 平台类型
     *
     * @mbggenerated
     */
    public void setPlatForm(Integer platForm) {
        this.platForm = platForm;
    }

    /**
     * @return app_vest_bag.about_us: 关于我们
     *
     * @mbggenerated
     */
    public String getAboutUs() {
        return aboutUs;
    }

    /**
     * 字段: app_vest_bag.about_us<br/>
     * 必填: false<br/>
     * 缺省: <br/>
     * 长度: 65535<br/>
     * 说明: 关于我们
     *
     * @mbggenerated
     */
    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_vest_bag
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
        AppVestBag other = (AppVestBag) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShareUrl() == null ? other.getShareUrl() == null : this.getShareUrl().equals(other.getShareUrl()))
            && (this.getTwoCode() == null ? other.getTwoCode() == null : this.getTwoCode().equals(other.getTwoCode()))
            && (this.getAndroidUrl() == null ? other.getAndroidUrl() == null : this.getAndroidUrl().equals(other.getAndroidUrl()))
            && (this.getIosUrl() == null ? other.getIosUrl() == null : this.getIosUrl().equals(other.getIosUrl()))
            && (this.getServiceContract() == null ? other.getServiceContract() == null : this.getServiceContract().equals(other.getServiceContract()))
            && (this.getServiceQq1() == null ? other.getServiceQq1() == null : this.getServiceQq1().equals(other.getServiceQq1()))
            && (this.getServiceQq2() == null ? other.getServiceQq2() == null : this.getServiceQq2().equals(other.getServiceQq2()))
            && (this.getH5Url() == null ? other.getH5Url() == null : this.getH5Url().equals(other.getH5Url()))
            && (this.getAppApi() == null ? other.getAppApi() == null : this.getAppApi().equals(other.getAppApi()))
            && (this.getWebApi() == null ? other.getWebApi() == null : this.getWebApi().equals(other.getWebApi()))
            && (this.getFpApi() == null ? other.getFpApi() == null : this.getFpApi().equals(other.getFpApi()))
            && (this.getChatWebsocket() == null ? other.getChatWebsocket() == null : this.getChatWebsocket().equals(other.getChatWebsocket()))
            && (this.getSgWebsocket() == null ? other.getSgWebsocket() == null : this.getSgWebsocket().equals(other.getSgWebsocket()))
            && (this.getDirectKj() == null ? other.getDirectKj() == null : this.getDirectKj().equals(other.getDirectKj()))
            && (this.getFileUpload() == null ? other.getFileUpload() == null : this.getFileUpload().equals(other.getFileUpload()))
            && (this.getH5url() == null ? other.getH5url() == null : this.getH5url().equals(other.getH5url()))
            && (this.getDownloadUrl() == null ? other.getDownloadUrl() == null : this.getDownloadUrl().equals(other.getDownloadUrl()))
            && (this.getIosDownloadUrl() == null ? other.getIosDownloadUrl() == null : this.getIosDownloadUrl().equals(other.getIosDownloadUrl()))
            && (this.getAndroidDownloadUrl() == null ? other.getAndroidDownloadUrl() == null : this.getAndroidDownloadUrl().equals(other.getAndroidDownloadUrl()))
            && (this.getPayUrl() == null ? other.getPayUrl() == null : this.getPayUrl().equals(other.getPayUrl()))
            && (this.getBbswebInterface() == null ? other.getBbswebInterface() == null : this.getBbswebInterface().equals(other.getBbswebInterface()))
            && (this.getBbsappInterface() == null ? other.getBbsappInterface() == null : this.getBbsappInterface().equals(other.getBbsappInterface()))
            && (this.getChatUrl() == null ? other.getChatUrl() == null : this.getChatUrl().equals(other.getChatUrl()))
            && (this.getChatType() == null ? other.getChatType() == null : this.getChatType().equals(other.getChatType()))
            && (this.getPlatForm() == null ? other.getPlatForm() == null : this.getPlatForm().equals(other.getPlatForm()))
            && (this.getAboutUs() == null ? other.getAboutUs() == null : this.getAboutUs().equals(other.getAboutUs()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_vest_bag
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShareUrl() == null) ? 0 : getShareUrl().hashCode());
        result = prime * result + ((getTwoCode() == null) ? 0 : getTwoCode().hashCode());
        result = prime * result + ((getAndroidUrl() == null) ? 0 : getAndroidUrl().hashCode());
        result = prime * result + ((getIosUrl() == null) ? 0 : getIosUrl().hashCode());
        result = prime * result + ((getServiceContract() == null) ? 0 : getServiceContract().hashCode());
        result = prime * result + ((getServiceQq1() == null) ? 0 : getServiceQq1().hashCode());
        result = prime * result + ((getServiceQq2() == null) ? 0 : getServiceQq2().hashCode());
        result = prime * result + ((getH5Url() == null) ? 0 : getH5Url().hashCode());
        result = prime * result + ((getAppApi() == null) ? 0 : getAppApi().hashCode());
        result = prime * result + ((getWebApi() == null) ? 0 : getWebApi().hashCode());
        result = prime * result + ((getFpApi() == null) ? 0 : getFpApi().hashCode());
        result = prime * result + ((getChatWebsocket() == null) ? 0 : getChatWebsocket().hashCode());
        result = prime * result + ((getSgWebsocket() == null) ? 0 : getSgWebsocket().hashCode());
        result = prime * result + ((getDirectKj() == null) ? 0 : getDirectKj().hashCode());
        result = prime * result + ((getFileUpload() == null) ? 0 : getFileUpload().hashCode());
        result = prime * result + ((getH5url() == null) ? 0 : getH5url().hashCode());
        result = prime * result + ((getDownloadUrl() == null) ? 0 : getDownloadUrl().hashCode());
        result = prime * result + ((getIosDownloadUrl() == null) ? 0 : getIosDownloadUrl().hashCode());
        result = prime * result + ((getAndroidDownloadUrl() == null) ? 0 : getAndroidDownloadUrl().hashCode());
        result = prime * result + ((getPayUrl() == null) ? 0 : getPayUrl().hashCode());
        result = prime * result + ((getBbswebInterface() == null) ? 0 : getBbswebInterface().hashCode());
        result = prime * result + ((getBbsappInterface() == null) ? 0 : getBbsappInterface().hashCode());
        result = prime * result + ((getChatUrl() == null) ? 0 : getChatUrl().hashCode());
        result = prime * result + ((getChatType() == null) ? 0 : getChatType().hashCode());
        result = prime * result + ((getPlatForm() == null) ? 0 : getPlatForm().hashCode());
        result = prime * result + ((getAboutUs() == null) ? 0 : getAboutUs().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_vest_bag
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
        sb.append(", shareUrl=").append(shareUrl);
        sb.append(", twoCode=").append(twoCode);
        sb.append(", androidUrl=").append(androidUrl);
        sb.append(", iosUrl=").append(iosUrl);
        sb.append(", serviceContract=").append(serviceContract);
        sb.append(", serviceQq1=").append(serviceQq1);
        sb.append(", serviceQq2=").append(serviceQq2);
        sb.append(", h5Url=").append(h5Url);
        sb.append(", appApi=").append(appApi);
        sb.append(", webApi=").append(webApi);
        sb.append(", fpApi=").append(fpApi);
        sb.append(", chatWebsocket=").append(chatWebsocket);
        sb.append(", sgWebsocket=").append(sgWebsocket);
        sb.append(", directKj=").append(directKj);
        sb.append(", fileUpload=").append(fileUpload);
        sb.append(", h5url=").append(h5url);
        sb.append(", downloadUrl=").append(downloadUrl);
        sb.append(", iosDownloadUrl=").append(iosDownloadUrl);
        sb.append(", androidDownloadUrl=").append(androidDownloadUrl);
        sb.append(", payUrl=").append(payUrl);
        sb.append(", bbswebInterface=").append(bbswebInterface);
        sb.append(", bbsappInterface=").append(bbsappInterface);
        sb.append(", chatUrl=").append(chatUrl);
        sb.append(", chatType=").append(chatType);
        sb.append(", platForm=").append(platForm);
        sb.append(", aboutUs=").append(aboutUs);
        sb.append("]");
        return sb.toString();
    }
}