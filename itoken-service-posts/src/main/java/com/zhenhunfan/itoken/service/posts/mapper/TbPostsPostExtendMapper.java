package com.zhenhunfan.itoken.service.posts.mapper;

import com.zhenhunfan.itoken.common.domain.TbPostsPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface TbPostsPostExtendMapper extends MyMapper<TbPostsPost> {
}