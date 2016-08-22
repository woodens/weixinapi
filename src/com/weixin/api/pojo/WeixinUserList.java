package com.weixin.api.pojo;

import java.util.List;

/**
 * 关注用户列表
 * 
 */
public class WeixinUserList {
	// 公众账号的总关注用户数
	private int total;
	// 获取的OpenID个数
	private int count;
	// OpenID列表
	private List<String> openidList;
	// 拉取列表的后一个用户的OPENID
	private String nextOpenid;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getOpenidList() {
		return openidList;
	}

	public void setOpenidList(List<String> openidList) {
		this.openidList = openidList;
	}

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}
}
