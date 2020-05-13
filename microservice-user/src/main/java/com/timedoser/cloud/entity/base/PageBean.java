package com.timedoser.cloud.entity.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tcyeee
 * @date 2019/11/13 15:21
 */
@Data
public class PageBean implements Serializable {
    private static final long serialVersionUID = -6165567294525365157L;

    private int pageNum = 1;
    private int pageSize = 20;

}
