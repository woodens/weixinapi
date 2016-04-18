package com.weixin.api.message.kfres;

import com.weixin.api.message.kfres.BaseKfResMessage;
import com.weixin.api.message.kfres.Text;

/**
 * 客服发送的文本消息
 * @author 张超
 */
public class TextKfResMessage extends BaseKfResMessage {
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
