package com.likes.common.mybatis.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户购买理财设置
 * 
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
@Mapper
public interface FinancesManagerProductSettingMapper extends SuperMapper<FinancesManagerProductSetting> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinancesManagerProductSetting> findList(Page<FinancesManagerProductSetting> page, @Param("p") Map<String, Object> params);
    List<FinancesManagerProductSetting> findList( @Param("p") Map<String, Object> params);
}
