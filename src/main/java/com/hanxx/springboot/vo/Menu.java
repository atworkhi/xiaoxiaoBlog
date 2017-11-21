package com.hanxx.springboot.vo;

import java.io.Serializable;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 17:29 2017/11/7
 * @Description: <p>
 * <p>标签菜单
 */
public class Menu implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected Menu() {
    }

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
