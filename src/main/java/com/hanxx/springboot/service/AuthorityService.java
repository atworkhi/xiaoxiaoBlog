package com.hanxx.springboot.service;

import com.hanxx.springboot.domain.Authority;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:33 2017/11/8
 * @Description: <p>
 * <p> 权限的服务
 */
public interface AuthorityService {
    /**
     * 根据ID查询权限
     * @param id
     * @return
     */
    Authority getAuthorityById(Long id);
}
