package com.weixin.api.message.res;

/**
 * 文本消息
 * Created by sky on 2015/1/22.
 */
public class TextResMessage extends BaseResMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
