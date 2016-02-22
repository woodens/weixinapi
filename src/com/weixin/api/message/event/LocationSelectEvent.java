package com.weixin.api.message.event;

/**
 * 弹出地理位置选择器的事件推送
 *
 */
public class LocationSelectEvent extends BaseEvent{
	//事件KEY值，由开发者在创建菜单时设定
	private String EventKey;
	//发送的位置信息
	private SendLocationInfo SendLocationInfo;
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public SendLocationInfo getSendLocationInfo() {
		return SendLocationInfo;
	}
	public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}
}
