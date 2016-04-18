package com.weixin.api.message.kfres;

import com.weixin.api.message.kfres.BaseKfResMessage;
import com.weixin.api.message.kfres.Image;

/**
 * 图片客服消息
 *
 * @author 张超
 */
public class ImageKfResMessage extends BaseKfResMessage {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
