package com.weixin.api.message.kfres;

/**
 * 客服回复音乐消息
 * @author 张超
 */
public class MusicKfResMessage extends BaseKfResMessage {
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
