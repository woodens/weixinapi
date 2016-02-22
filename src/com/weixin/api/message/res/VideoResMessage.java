package com.weixin.api.message.res;

/**
 * 回复视频消息
 *
 */
public class VideoResMessage extends BaseResMessage{
	//视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

}
