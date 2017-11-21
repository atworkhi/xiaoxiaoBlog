package com.hanxx.springboot.vo;

import com.hanxx.springboot.domain.Catalog;

import java.io.Serializable;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 12:38 2017/11/17
 * @Description: <p>
 * <p>
 */
public class CatalogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private Catalog catalog;

    public CatalogVO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
