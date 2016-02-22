package com.weixin.api.message.res;

/**
 * 音乐消息
 * 
 * @author sky
 */
public class MusicResMessage extends BaseResMessage {
	//音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
