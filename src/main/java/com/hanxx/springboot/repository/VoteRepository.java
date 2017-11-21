package com.hanxx.springboot.repository;

import com.hanxx.springboot.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 15:35 2017/11/16
 * @Description: <p>
 * <p>
 */
public interface VoteRepository extends JpaRepository<Vote,Long>{
}
