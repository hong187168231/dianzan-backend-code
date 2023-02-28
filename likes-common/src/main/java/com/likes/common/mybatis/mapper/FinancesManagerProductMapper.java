package com.likes.common.mybatis.mapper;

import com.github.pagehelper.Page;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 理财产品设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface FinancesManagerProductMapper extends BaseMapper<FinancesManagerProduct> {
    /**
     * 分页查询用户列表
     *
     * @param params
     * @return
     */
    Page<FinancesManagerProduct> findList(@Param("p") Map<String, Object> params, RowBounds rowBounds);

    List<FinancesManagerProduct> findList(@Param("p") Map<String, Object> params);

}
