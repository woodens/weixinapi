package com.weixin.api.menu;

/**
 * 主菜单
 * Created by sky on 2015/1/22.
 */
public class MainButton extends Button {
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
