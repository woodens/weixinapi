package com.weixin.api.message.kfres;

/**
 * 客服发送的消息
 * @author 张超
 */
public class BaseKfResMessage {
    private String touser;  //普通用户openid
    private String msgtype; //消息类型

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
