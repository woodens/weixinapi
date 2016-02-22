package com.weixin.api.message.res;

/**
 * 回复图片消息
 *
 */
public class ImageResMessage extends BaseResMessage{
	//通过上传多媒体文件，得到的id
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
