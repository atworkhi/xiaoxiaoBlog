package com.hanxx.springboot.service.impl;

import com.hanxx.springboot.domain.Authority;
import com.hanxx.springboot.repository.AuthorityRepository;
import com.hanxx.springboot.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:34 2017/11/8
 * @Description: <p>
 * <p> 权限的实现
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}
