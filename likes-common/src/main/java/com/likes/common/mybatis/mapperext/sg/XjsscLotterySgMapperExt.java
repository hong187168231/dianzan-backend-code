package com.likes.common.mybatis.mapperext.sg;


import com.likes.common.mybatis.entity.XjsscLotterySg;

import java.util.List;
import java.util.Map;

/**
 * @Date:Created in 16:142019/12/7
 * @Descriotion
 * @Author
 **/
public interface XjsscLotterySgMapperExt {
    int openCountByExample(Map<String, Object> map);

    int updateByIssue(XjsscLotterySg updateSg);

    int insertBatch(List<XjsscLotterySg> list);
}
