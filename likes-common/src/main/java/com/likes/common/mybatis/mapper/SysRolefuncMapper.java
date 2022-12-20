package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.SysRolefunc;
import com.likes.common.mybatis.entity.SysRolefuncExample;
import com.likes.common.mybatis.entity.SysRolefuncKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolefuncMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int countByExample(SysRolefuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int deleteByExample(SysRolefuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(SysRolefuncKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int insert(SysRolefunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int insertSelective(SysRolefunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    SysRolefunc selectOneByExample(SysRolefuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    List<SysRolefunc> selectByExample(SysRolefuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    SysRolefunc selectByPrimaryKey(SysRolefuncKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysRolefunc record, @Param("example") SysRolefuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysRolefunc record, @Param("example") SysRolefuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysRolefunc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_rolefunc
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysRolefunc record);
}