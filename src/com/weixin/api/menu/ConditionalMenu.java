package com.weixin.api.menu;

/**
 * 个性化菜单
 * Created by 张超 on 2016/4/12.
 */
public class ConditionalMenu extends Menu{
    private MatchRule matchrule;//规则

    public MatchRule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(MatchRule matchrule) {
        this.matchrule = matchrule;
    }
}
