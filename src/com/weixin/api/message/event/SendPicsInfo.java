package com.weixin.api.message.event;

import java.util.List;

/**
 * 发送的图片信息
 *
 */
public class SendPicsInfo {
	//发送的图片数量
	private int Count;
	//图片列表
	private List<Pic> PicList;
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public List<Pic> getPicList() {
		return PicList;
	}
	public void setPicList(List<Pic> picList) {
		PicList = picList;
	}
	
}
