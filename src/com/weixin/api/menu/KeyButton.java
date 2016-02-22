package com.weixin.api.menu;

/**
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午5:14:24
 * @version 1.0
 */
public class KeyButton extends Button{
	//菜单的响应动作类型
	private String type;
	//菜单KEY值，用于消息接口推送，不超过128字节
    private String key;
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
