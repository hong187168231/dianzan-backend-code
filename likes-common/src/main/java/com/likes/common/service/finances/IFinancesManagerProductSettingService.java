package com.likes.common.service.finances;

import com.likes.common.model.LoginUser;
import com.likes.common.model.common.PageBounds;
import com.likes.common.model.common.PageResult;
import com.likes.common.mybatis.entity.FinancesManagerProductSetting;

import java.util.List;
import java.util.Map;

/**
 * 用户购买理财设置
 *
 * @author yixiu
 * @date 2023-02-27 14:49:00
 */
public interface IFinancesManagerProductSettingService {
    /**
     * 列表
     *
     * @param params
     * @return
     */
    PageResult findListPage(Map<String, Object> params, PageBounds pageBounds);

    List<FinancesManagerProductSetting> findList(Map<String, Object> params);

    void saveOrUpdate(FinancesManagerProductSetting financesManagerProductSetting, LoginUser loginUser);

    FinancesManagerProductSetting getById(Long id);

    boolean removeById(Long id);
}

