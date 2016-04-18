package com.weixin.api.message.kfres;

/**
 * 点击跳转到图文消息页面的客服多图文消息
 * @author 张超
 * @date 16/4/18
 */
public class MpnewsKfResMessage extends BaseKfResMessage {
    private Mpnews mpnews;

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }
}
