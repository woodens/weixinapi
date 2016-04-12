package com.weixin.api.message.event;

/**
 * 自定义菜单事件
 *	Event	事件类型，CLICK
 */
public class MenuEvent extends BaseEvent{
	//点击菜单拉取消息时的事件推送:事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
