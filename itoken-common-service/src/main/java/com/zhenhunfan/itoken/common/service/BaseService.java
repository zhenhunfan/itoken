package com.zhenhunfan.itoken.common.service;

import com.github.pagehelper.PageInfo;
import com.zhenhunfan.itoken.common.domain.BaseDomain;

/**
 * <p>Title: BaseService</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/19
 */
public interface BaseService<T extends BaseDomain> {
    int insert(T t,String createBy);

    int delete(T t);

    int update(T t,String updateBy);

    int count(T t);

    T selectOne(T t);

    PageInfo<T> page(int pageNum,int pageSize,T t);
}
