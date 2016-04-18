package com.weixin.api.message.kfres;

import java.util.List;

/**
 * @author 张超
 * 创建于 16/4/18
 */
public class News {
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
