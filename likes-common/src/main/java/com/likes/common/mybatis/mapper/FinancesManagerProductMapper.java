package com.likes.common.mybatis.mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.likes.common.mybatis.entity.FinancesManagerProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 理财产品设置
 * 
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Mapper
public interface FinancesManagerProductMapper extends SuperMapper<FinancesManagerProduct> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinancesManagerProduct> findList(Page<FinancesManagerProduct> page, @Param("p") Map<String, Object> params);

    List<FinancesManagerProduct> findList( @Param("p") Map<String, Object> params);
}
