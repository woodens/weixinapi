package com.weixin.api.message.req;

/**
 * 图片消息
 *
 * Created by sky on 2015/1/22.
 */
public class ImageReqMessage extends BaseReqMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
