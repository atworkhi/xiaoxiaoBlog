package com.hanxx.springboot.service;

import com.hanxx.springboot.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 15:42 2017/11/7
 * @Description: <p>
 * <p>  用户服务接口
 */

public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void removeUser(Long id);

    /**
     * 批量删除用户列表的所有用户
     * @param users
     */
    void removeUsersInBarch(List<User> users);

    /**
     * 更新用户
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取所有用户
     * @return
     */
    List<User> listUsers();

    /**
     * 根据用户名字进行分页模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    /**
     * 更具名称列表查询
     * @param usernames
     * @return
     */
    List<User> listUsersByUsernames(Collection<String> usernames);

    /**
     * 根据用户名查询是用户否存在
     * @param username
     * @return
     */
    User findByUsername(String username);
}
