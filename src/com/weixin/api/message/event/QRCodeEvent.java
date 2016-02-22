package com.weixin.api.message.event;

/**
 * 扫描带参数二维码事件
 *
 */
public class QRCodeEvent extends BaseEvent{
	//二维码的ticket，可用来换取二维码图片
	private String Ticket;
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
