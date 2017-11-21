package com.hanxx.springboot.service;

import com.hanxx.springboot.domain.Catalog;
import com.hanxx.springboot.domain.User;

import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 12:41 2017/11/17
 * @Description: <p>
 * <p>
 */
public interface CatalogService {

    /**
     * 保存Catalog
     * @param catalog
     * @return
     */
    Catalog saveCatalog(Catalog catalog);

    /**
     * 删除Catalog
     * @param id
     * @return
     */
    void removeCatalog(Long id);

    /**
     * 根据id获取Catalog
     * @param id
     * @return
     */
    Catalog getCatalogById(Long id);

    /**
     * 获取Catalog列表
     * @return
     */
    List<Catalog> listCatalogs(User user);
}
