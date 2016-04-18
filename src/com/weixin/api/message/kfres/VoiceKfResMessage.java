package com.weixin.api.message.kfres;

import com.weixin.api.message.kfres.BaseKfResMessage;
import com.weixin.api.message.kfres.Voice;

/**
 * @author 张超
 */
public class VoiceKfResMessage extends BaseKfResMessage {
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
