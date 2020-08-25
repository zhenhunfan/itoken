package com.zhenhunfan.itoken.service.posts.service;

import com.zhenhunfan.itoken.common.domain.BaseDomain;
import com.zhenhunfan.itoken.common.service.BaseService;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <p>Title: PostsService</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/20
 */

public interface PostsService<T extends BaseDomain> extends BaseService<T> {
}
