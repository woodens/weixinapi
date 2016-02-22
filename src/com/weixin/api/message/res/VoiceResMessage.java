package com.weixin.api.message.res;

import com.weixin.api.message.req.BaseReqMessage;

/**
 * 回复语音消息
 *
 */
public class VoiceResMessage extends BaseReqMessage {
	//通过上传多媒体文件，得到的id
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
