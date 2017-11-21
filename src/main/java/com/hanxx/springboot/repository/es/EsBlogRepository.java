package com.hanxx.springboot.repository.es;

import com.hanxx.springboot.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 全局搜索
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 19:50 2017/11/17
 * @Description: <p>
 * <p>
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String>{

    /**
     * 根据id查询
     * @param blogId
     * @return
     */
    EsBlog findByBlogId(Long blogId);

    /**
     * 模糊查询(去重)
     * @param title
     * @param summary
     * @param content
     * @param tags
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(
            String title,String summary,String content,String tags,Pageable pageable);

}
