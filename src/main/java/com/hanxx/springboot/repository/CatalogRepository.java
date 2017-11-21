package com.hanxx.springboot.repository;

import com.hanxx.springboot.domain.Catalog;
import com.hanxx.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 12:40 2017/11/17
 * @Description: <p>
 * <p>
 */
public interface CatalogRepository extends JpaRepository<Catalog,Long>{


    /**
     * 根据用户查询
     * @param user
     * @return
     */
    List<Catalog> findByUser(User user);

    /**
     * 根据用户查询
     * @param user
     * @param name
     * @return
     */
    List<Catalog> findByUserAndName(User user,String name);

}
