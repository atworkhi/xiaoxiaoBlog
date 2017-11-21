package com.hanxx.springboot.service.impl;

import com.hanxx.springboot.domain.Catalog;
import com.hanxx.springboot.domain.User;
import com.hanxx.springboot.repository.CatalogRepository;
import com.hanxx.springboot.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 12:42 2017/11/17
 * @Description: <p>
 * <p>
 */
@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private CatalogRepository catalogRepository;

    @Transactional
    @Override
    public Catalog saveCatalog(Catalog catalog) {
       //判断分类是否存在
        List<Catalog> list = catalogRepository.findByUserAndName(catalog.getUser(), catalog.getName());
        if(list !=null && list.size() > 0) {
            throw new IllegalArgumentException("该分类已经存在了");
        }
        return catalogRepository.save(catalog);
    }

    @Transactional
    @Override
    public void removeCatalog(Long id) {
        catalogRepository.delete(id);
    }

    @Override
    public Catalog getCatalogById(Long id) {
        return catalogRepository.findOne(id);
    }

    @Override
    public List<Catalog> listCatalogs(User user) {
        return catalogRepository.findByUser(user);
    }
}
