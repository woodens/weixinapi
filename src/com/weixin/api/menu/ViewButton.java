package com.weixin.api.menu;

/**
 * view类型的菜单
 * Created by sky on 2015/1/22.
 */
public class ViewButton extends UrlButton {
	/**
	 * 将button的type定义为view
	 */
	public ViewButton() {
		this.setType("view");
	}
}
