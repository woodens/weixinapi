package com.weixin.api.pojo;

/**
 * 调用微信JS接口的临时票据
 * @author 张超
 *
 */
public class JsapiTicket {
    /**临时票据*/
    private String jsapiTicket;
    /**多长时间内超时时间*/
    private int expiresIn;
    /**超时时间*/
    private Long expiresTime;
    public String getJsapiTicket() {
        return jsapiTicket;
    }
    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
    public Long getExpiresTime() {
        return expiresTime;
    }
    public void setExpiresTime(Long expiresTime) {
        this.expiresTime = expiresTime;
    }
}