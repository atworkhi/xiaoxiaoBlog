package com.hanxx.springboot.repository;

import com.hanxx.springboot.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 9:47 2017/11/15
 * @Description: <p>
 * <p>
 */
public interface CommentRepository extends JpaRepository<Comment,Long>{
}
