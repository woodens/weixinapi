package com.weixin.api.menu;

/**
 * 弹出地理位置选择器
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午5:30:07
 * @version 1.0
 */
public class LocationSelectButton extends KeyButton{

	/**
	 * 将type初始化为location_select
	 */
	public LocationSelectButton() {
		this.setType("location_select");
	}
	
}
