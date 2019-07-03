package com.zhangyang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: ZhangYang
 * @Date: 2019/2/10 15:09
 */
@Configuration
@PropertySource(value="classpath:application.properties")
public class WechatConfig {
    /**
     * 公众号appid
     */
    @Value("${wxpay.appid}")
    private String wxpid;
    /**
     * 公众号秘钥
     */
    @Value("${wxpay.appsecret}")
    private String appsecret;

    /**
     * 开放平台AppId
     */
    @Value("${wxopen.appid}")
    private String openAppId;

    /**
     * 开放平台秘钥
     */
    @Value("${wxopen.appsecret}")
    private String openSecret;
    /**
     * 回调地址
     */
    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;

    /**
     * 微信开放平台二维码连接
     */
    private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";

    /**
     * 开放平台获取access_token地址
     */
    private final static String OPEN_ACCESS_TOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * 获取用户信息
     */
    private final static String OPEN_USER_INFO_URL ="https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";


    /**
     * 商户号id
     */
    @Value("${wxpay.mer_id}")
    private String mchId;


    /**
     * 支付key
     */
    @Value("${wxpay.key}")
    private String key;

    /**
     * 微信支付回调url
     */
    @Value("${wxpay.callback}")
    private String payCallbackUrl;


    /**
     * 统一下单url
     */
    private static final String UNIFIED_ORDER_URL = "http://api.xdclass.net/pay/unifiedorder";

    public String getWxpid() {
        return wxpid;
    }

    public void setWxpid(String wxpid) {
        this.wxpid = wxpid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getOpenAppId() {
        return openAppId;
    }

    public void setOpenAppId(String openAppId) {
        this.openAppId = openAppId;
    }

    public String getOpenSecret() {
        return openSecret;
    }

    public void setOpenSecret(String openSecret) {
        this.openSecret = openSecret;
    }

    public String getOpenRedirectUrl() {
        return openRedirectUrl;
    }

    public void setOpenRedirectUrl(String openRedirectUrl) {
        this.openRedirectUrl = openRedirectUrl;
    }

    public static String getOpenQrcodeUrl() {
        return OPEN_QRCODE_URL;
    }

    public static String getOpenAccessTokenUrl() {
        return OPEN_ACCESS_TOKEN_URL;
    }
    public static String getOpenUserInfoUrl() {
        return OPEN_USER_INFO_URL;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPayCallbackUrl() {
        return payCallbackUrl;
    }

    public void setPayCallbackUrl(String payCallbackUrl) {
        this.payCallbackUrl = payCallbackUrl;
    }

    public static String getUnifiedOrderUrl() {
        return UNIFIED_ORDER_URL;
    }
}
