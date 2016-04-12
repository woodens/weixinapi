package com.weixin.api.message.res;

/**
 * 回复语音消息中的音乐素材
 * Created by 张超 on 2016/4/12.
 */
public class Voice {
    //通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
