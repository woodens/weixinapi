package com.weixin.api.message.event;

public class Pic {
	//图片的MD5值，开发者若需要，可用于验证接收到图片
	private String PicMd5Sum;

	public String getPicMd5Sum() {
		return PicMd5Sum;
	}

	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}
}
