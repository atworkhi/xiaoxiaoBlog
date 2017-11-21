package com.hanxx.springboot.repository;

import com.hanxx.springboot.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:31 2017/11/8
 * @Description: <p>
 * <p>权限的资源库
 */
public interface AuthorityRepository extends JpaRepository<Authority,Long>{
}
