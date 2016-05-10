package com.weixin.api.menu;

/**
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午5:14:34
 * @version 1.0
 */
public class UrlButton extends Button {
	//菜单的响应动作类型
	private String type;
	//网页链接，用户点击菜单可打开链接，不超过256字节
    private String url;
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
