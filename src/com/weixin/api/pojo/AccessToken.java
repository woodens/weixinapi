package com.weixin.api.pojo;

/**
 * 微信通用接口凭证
 *
 * Created by sky on 2015/1/22.
 */
public class AccessToken {
    // 获取到的凭证
    private String accessToken;
    // 凭证有效时间，单位：秒
    private int expiresIn;
    public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
