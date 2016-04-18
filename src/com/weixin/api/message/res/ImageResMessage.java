package com.weixin.api.message.res;

/**
 * 回复图片消息
 *
 */
public class ImageResMessage extends BaseResMessage{
	//通过上传多媒体文件，得到的id
	private Image Image;

	public com.weixin.api.message.res.Image getImage() {
		return Image;
	}

	public void setImage(com.weixin.api.message.res.Image image) {
		Image = image;
	}
}
