package com.zhenhunfan.itoken.common.hystrix;

import com.google.common.collect.Lists;
import com.zhenhunfan.itoken.common.constants.HttpStatusConstans;
import com.zhenhunfan.itoken.common.dto.BaseResult;
import com.zhenhunfan.itoken.common.utils.MapperUtils;

/**
 * <p>Title: Fallback</p>
 * <p>Description: 通用的熔断方法</p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/18
 */
public class Fallback {
    /**
     * 502
     * @return
     */
    public static String badGateway(){
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(String.valueOf(HttpStatusConstans.BAD_GATEWAY.getStatus()),
                        HttpStatusConstans.BAD_GATEWAY.getContent())));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
