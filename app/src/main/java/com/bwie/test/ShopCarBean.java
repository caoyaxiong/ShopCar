package com.bwie.test;

import java.util.Iterator;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/22 11:31
 */

public class ShopCarBean {
    private String tv_title;
    private int tv_price;
    private int tv_count;
    private boolean tv_checkBox;

    public ShopCarBean() {
    }

    public ShopCarBean(String tv_title, int tv_price, int tv_count) {
        this.tv_title = tv_title;
        this.tv_price = tv_price;
        this.tv_count = tv_count;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public int getTv_price() {
        return tv_price;
    }

    public void setTv_price(int tv_price) {
        this.tv_price = tv_price;
    }

    public int getTv_count() {
        return tv_count;
    }

    public void setTv_count(int tv_count) {
        this.tv_count = tv_count;
    }

    public boolean isTv_checkBox() {
        return tv_checkBox;
    }

    public void setTv_checkBox(boolean tv_checkBox) {
        this.tv_checkBox = tv_checkBox;
    }
}
