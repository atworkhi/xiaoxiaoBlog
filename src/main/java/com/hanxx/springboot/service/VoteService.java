package com.hanxx.springboot.service;

import com.hanxx.springboot.domain.Vote;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 15:36 2017/11/16
 * @Description: <p>
 * <p> 点赞
 */
public interface VoteService {

    /**
     * 根据id获取 Vote
     * @param id
     * @return
     */
    Vote getVoteById(Long id);
    /**
     * 删除Vote
     * @param id
     * @return
     */
    void removeVote(Long id);
}
