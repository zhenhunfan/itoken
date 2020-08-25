package com.zhenhunfan.itoken.common.web.components;

import com.zhenhunfan.itoken.common.dto.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>Title: DataTablesResult</p>
 * <p>Description: 结果集</p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataTablesResult extends BaseResult implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private String error;
}
