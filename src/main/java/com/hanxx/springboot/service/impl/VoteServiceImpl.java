package com.hanxx.springboot.service.impl;

import com.hanxx.springboot.domain.Vote;
import com.hanxx.springboot.repository.VoteRepository;
import com.hanxx.springboot.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 15:36 2017/11/16
 * @Description: <p>
 * <p>
 */
@Service
public class VoteServiceImpl implements VoteService{

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote getVoteById(Long id) {
        return voteRepository.findOne(id);
    }

    @Transactional
    @Override
    public void removeVote(Long id) {
        voteRepository.delete(id);
    }
}
