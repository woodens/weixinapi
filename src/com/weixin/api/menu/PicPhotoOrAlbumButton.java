package com.weixin.api.menu;

/**
 * 弹出拍照或者相册发图
 * @author 作者：张超
 * @date     创建时间：2015年4月15日 下午5:27:09
 * @version 1.0
 */
public class PicPhotoOrAlbumButton extends KeyButton{
	private Button[] sub_button;//目前微信中设置为空，预留的
	/**
	 * 将type初始化为pic_photo_or_album
	 */
	public PicPhotoOrAlbumButton() {
		this.setType("pic_photo_or_album");
	}

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
