package com.likes.common.mybatis.mapper;

import com.github.pagehelper.Page;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 用户购买理财设置
 * 
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface FinancesManagerProductSettingMapper extends BaseMapper<FinancesManagerProductSetting> {

    /**
     * 分页查询用户列表
     * @param params
     * @return
     */
    Page<FinancesManagerProductSetting> findList(@Param("p") Map<String, Object> params, RowBounds rowBounds);


    List<FinancesManagerProductSetting> findList(@Param("p") Map<String, Object> params);
}
