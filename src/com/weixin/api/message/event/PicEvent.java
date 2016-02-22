package com.weixin.api.message.event;


/**
 * 弹出系统拍照发图的事件推送/弹出拍照或者相册发图的事件推送
 * @author sky
 *
 */
public class PicEvent extends BaseEvent{
	//发送的图片信息
	private SendPicsInfo SendPicsInfo;
	public SendPicsInfo getSendPicsInfo() {
		return SendPicsInfo;
	}
	public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}
}
