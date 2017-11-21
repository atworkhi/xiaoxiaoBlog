package com.hanxx.springboot.service;

import com.hanxx.springboot.domain.Comment;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 9:51 2017/11/15
 * @Description: <p>
 * <p> 评论
 */
public interface CommentService {

    /**
     * 根据id获取 Comment
     * @param id
     * @return
     */
    Comment getCommentById(Long id);
    /**
     * 删除评论
     * @param id
     * @return
     */
    void removeComment(Long id);
}
