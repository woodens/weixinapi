package com.weixin.api.menu;

/**
 * 扫码推事件
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午5:11:13
 * @version 1.0
 */
public class ScancodePushButton extends KeyButton{

	private Button[] sub_button;//目前微信中设置为空，预留的
	/**
	 * 将type初始化为scancode_push
	 */
	public ScancodePushButton() {
		this.setType("scancode_push");
	}

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
