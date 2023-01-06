package com.likes.common.model;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author abu
 * @version 1.0
 * @Description APP用户登录用户信息
 * @revise
 * @time 2018年6月6日 下午4:51:12
 */
@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = -2359328898380217910L;

    private String acctoken;
    /**
     * 用户id
     */
    private Long memid;
    /**
     * 会员标识号
     */
    private String accno;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 真是姓名
     */
    private String memname;
    /**
     * 手机号码
     */
    private String mobileno;
    /**
     * 会员等级
     */
    private String memlevel;

    /**
     * 会员等级序号
     */
    private Integer levelSeq;

    /**
     * 头像图片地址
     */
    private String headimgurl;
    /**
     * 会员账号--登录用
     */
    private String acclogin;
    /**
     * 账号类型：  普通会员1      主播2   家族长3   运营后台管理员8    第三方登录7   服务注册中心管理员9  聚合站点后台管理员10   // 11 试玩账号
     */
    private Integer logintype;

    /**
     * 登录ip地址
     */
    private String clintipadd;
    /**
     * 推荐码
     */
    private String recomcode;
    private String higherRecomcode;
    // 缓存图片
    private List<String> cacheimages;
    // 登录国家
    private String region;
    // 上级
    private String higher;


    // 后台
    private String bduserid;
    private String bdusername;
    private String phoneno;
    private String email;
    private Long sysroleid;
    private String rolename;
    private String levelSvgaUrl;
    private JSONArray functions;
    /**
     * 主表id
     */
    private Long loginid;

    /**
     * 登录来源 IOS 安卓 h5 web
     */
    private String sourceType;

    /**
     * 是否已被要请 true 邀请过, false 没有
     */
    private Boolean invitationStatus;

    /**
     * 总代理账号
     */
    private String headAccno;

    /**
     * 主播端平台配置信息
     */
    private Map<String, Object> basPlatformInfo;

}
