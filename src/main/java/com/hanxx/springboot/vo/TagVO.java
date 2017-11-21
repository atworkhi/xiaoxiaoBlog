package com.hanxx.springboot.vo;

import java.io.Serializable;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 20:01 2017/11/17
 * @Description: <p>
 * <p>
 */
public class TagVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Long count;

    public TagVO(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
