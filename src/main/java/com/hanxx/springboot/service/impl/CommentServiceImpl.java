package com.hanxx.springboot.service.impl;

import com.hanxx.springboot.domain.Comment;
import com.hanxx.springboot.repository.CommentRepository;
import com.hanxx.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 9:52 2017/11/15
 * @Description: <p>
 * <p> 评论实现的实现层
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 根基id查询
     * @param id
     * @return
     */
    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findOne(id);
    }

    /**
     * 删除
     * @param id
     */

    @Override
    @Transactional
    public void removeComment(Long id) {
        commentRepository.delete(id);
    }

}
