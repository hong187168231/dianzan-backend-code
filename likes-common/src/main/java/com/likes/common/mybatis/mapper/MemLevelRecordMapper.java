package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.MemLevelRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface MemLevelRecordMapper extends Mapper<MemLevelRecord> {

    @Select("SELECT count(1) from dz_level_record WHERE change_type = 1 and accno = #{accno}")
    int countFirstLevel(@Param("accno") String accno);

}
