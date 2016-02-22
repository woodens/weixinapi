package com.weixin.api.pojo;

/**
 * 客服基本信息
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午11:46:30
 * @version 1.0
 */
public class KfInfo {
	//完整客服账号
	private String kf_account;
	//客服头像url
	private String kf_headimgurl;
	//客服工号
	private String kf_id;
	//客服昵称
	private String kf_nick;
	public String getKf_account() {
		return kf_account;
	}
	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}
	public String getKf_headimgurl() {
		return kf_headimgurl;
	}
	public void setKf_headimgurl(String kf_headimgurl) {
		this.kf_headimgurl = kf_headimgurl;
	}
	public String getKf_id() {
		return kf_id;
	}
	public void setKf_id(String kf_id) {
		this.kf_id = kf_id;
	}
	public String getKf_nick() {
		return kf_nick;
	}
	public void setKf_nick(String kf_nick) {
		this.kf_nick = kf_nick;
	}
}
