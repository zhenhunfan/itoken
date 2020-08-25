package com.zhenhunfan.itoken.service.posts.service.impl;

import com.zhenhunfan.itoken.common.domain.TbPostsPost;
import com.zhenhunfan.itoken.common.mapper.TbPostsPostMapper;
import com.zhenhunfan.itoken.common.service.impl.BaseServiceImpl;
import com.zhenhunfan.itoken.service.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Title: PostsServiceImpl</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/20
 */
@Service
@Transactional(readOnly = true)
public class PostsServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements PostsService<TbPostsPost> {
}
