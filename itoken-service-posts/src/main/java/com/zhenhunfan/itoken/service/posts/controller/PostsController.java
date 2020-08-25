package com.zhenhunfan.itoken.service.posts.controller;

import com.github.pagehelper.PageInfo;
import com.zhenhunfan.itoken.common.domain.TbPostsPost;
import com.zhenhunfan.itoken.common.dto.BaseResult;
import com.zhenhunfan.itoken.common.mapper.TbPostsPostMapper;
import com.zhenhunfan.itoken.common.utils.MapperUtils;
import com.zhenhunfan.itoken.service.posts.service.PostsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>Title: PostsController</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/20
 */
@RestController
@RequestMapping(value = "v1/posts")
public class PostsController {

    @Autowired
    private PostsService<TbPostsPost> postsService;

    /**
     * 根据 ID 获取文章
     *
     * @param postGuid 主键
     * @return 通用结果对象
     */
    @RequestMapping(value = "{postGuid}", method = RequestMethod.GET)
    public BaseResult get(
            @PathVariable(value = "postGuid") String postGuid) {
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(postGuid);
        TbPostsPost obj = postsService.selectOne(tbPostsPost);
        return BaseResult.ok(obj);
    }

    /**
     * 保存文章
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResult save(
            @RequestParam() String tbPostsPostJson,
            @RequestParam() String optsBy
    ) {
        int result;

        TbPostsPost tbPostsPost = null;
        try {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tbPostsPost != null) {
            // 主键为空，表示新增
            if (StringUtils.isBlank(tbPostsPost.getPostGuid())) {
                tbPostsPost.setPostGuid(UUID.randomUUID().toString());
                result = postsService.insert(tbPostsPost, optsBy);
            }

            // 编辑
            else {
                result = postsService.update(tbPostsPost, optsBy);
            }

            if (result > 0) {
                return BaseResult.ok("保存文章成功");
            }
        }

        return BaseResult.ok("保存文章失败");
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param tbPostsPostJson
     * @return
     */
    @ApiOperation(value = "文章服务分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "tbPostsPostJson", value = "对象 JSON 格式", required = false, dataTypeClass = String.class, paramType = "json")
    })
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(required = true) int pageNum,
            @PathVariable(required = true) int pageSize,
            @RequestParam(required = false) String tbPostsPostJson
    ) throws Exception {

        TbPostsPost tbPostsPost = null;
        if (StringUtils.isNotBlank(tbPostsPostJson)) {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        }

        if(pageNum == 0)
            pageNum = 1;
        PageInfo pageInfo = postsService.page(pageNum, pageSize, tbPostsPost);

        // 分页后的结果集
        List<TbPostsPost> list = pageInfo.getList();

        // 封装 Cursor 对象
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal(new Long(pageInfo.getTotal()).intValue());
        cursor.setOffset(pageInfo.getPageNum());
        cursor.setLimit(pageInfo.getPageSize());

        return BaseResult.ok(list, cursor);
    }
}
