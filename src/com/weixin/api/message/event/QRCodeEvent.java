package com.weixin.api.message.event;

/**
 * 扫描带参数二维码事件
 *  Event 事件类型，
 *      用户未关注时：subscribe
 *      用户已关注时：SCAN
 */
public class QRCodeEvent extends BaseEvent{
	//事件key值
	private String EventKey;
	//二维码的ticket，可用来换取二维码图片
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
