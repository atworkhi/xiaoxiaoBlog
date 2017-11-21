package com.hanxx.springboot.repository;

import com.hanxx.springboot.domain.Blog;
import com.hanxx.springboot.domain.Catalog;
import com.hanxx.springboot.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 15:37 2017/11/14
 * @Description: <p>
 * <p> BlogRepository仓库
 */
public interface BlogRepository extends JpaRepository<Blog, Long>{
    /**
     * 根据用户名分页查询用户列表（最新）
     * 由 findByUserAndTitleLikeOrTagsLikeOrderByCreateTimeDesc 代替，可以根据标签进行查询
     * @param user
     * @param title
     * @param pageable
     * @return
     * @see
     */
    @Deprecated
    Page<Blog> findByUserAndTitleLikeOrderByCreateTimeDesc(User user, String title, Pageable pageable);

    /**
     * 根据用户名分页查询用户列表
     * @param user
     * @param title
     * @param
     * @param pageable
     * @return
     */
    Page<Blog> findByUserAndTitleLike(User user, String title, Pageable pageable);

    /**
     * 根据用户名分页查询用户列表
     * @param user
     * @param title
     * @param
     * @param pageable
     * @return
     */
    Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,User user,String tags,User user2,Pageable pageable);
    /**
     * 根据用户名分页查询用户列表
     * @param
     * @param
     * @param
     * @param pageable
     * @return
     */
    Page<Blog> findByCatalog(Catalog catalog, Pageable pageable);
}


