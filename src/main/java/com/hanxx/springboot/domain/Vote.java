package com.hanxx.springboot.domain;



import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 15:22 2017/11/16
 * @Description: <p>
 * <p> 点赞实体
 */
@Entity
public class Vote implements Serializable{

    private static final Long serialVersionUID=1L;

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //谁点赞
    @OneToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //时间戳
    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp createTime;

    //jpa规范
    protected Vote(){

    }

    public Vote(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

}
