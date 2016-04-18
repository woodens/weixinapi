package com.weixin.api.message.kfres;

/**
 * 点击跳转到外链的多图文客服消息
 * @author 张超
 * @date 16/4/18
 */
public class NewsKfResMessage extends BaseKfResMessage {
    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
