package com.hanxx.springboot.repository;

import com.hanxx.springboot.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:26 2017/11/7
 * @Description: <p>
 * <p> 用户的仓库
 */
public interface UserRepository extends JpaRepository<User,Long>{

    /**
     * 根据用户名进行模糊分页查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据用户账号查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据名称列表查询
     * @param usernames
     * @return
     */
    List<User> findByUsernameIn(Collection<String> usernames);


}
