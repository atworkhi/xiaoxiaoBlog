package com.hanxx.springboot.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:17 2017/11/8
 * @Description: <p>
 * <p> 权限管理实体
 */
@Entity
public class Authority implements GrantedAuthority{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Long id;

    //不能为空
    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    //用这方法返回getname
    @Override
    public String getAuthority() {
        return name;
    }
}
