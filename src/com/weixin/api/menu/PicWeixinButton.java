package com.weixin.api.menu;

/**
 * 弹出微信相册发图器
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午5:28:31
 * @version 1.0
 */
public class PicWeixinButton extends KeyButton{
	private Button[] sub_button;//目前微信中设置为空，预留的
	/**
	 * 将type初始化为pic_weixin
	 */
	public PicWeixinButton() {
		this.setType("pic_weixin");
	}

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
