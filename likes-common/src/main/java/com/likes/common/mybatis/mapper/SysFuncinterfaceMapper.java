package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.SysFuncinterface;
import com.likes.common.mybatis.entity.SysFuncinterfaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFuncinterfaceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int countByExample(SysFuncinterfaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int deleteByExample(SysFuncinterfaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long itfcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int insert(SysFuncinterface record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int insertSelective(SysFuncinterface record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    SysFuncinterface selectOneByExample(SysFuncinterfaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    List<SysFuncinterface> selectByExample(SysFuncinterfaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    SysFuncinterface selectByPrimaryKey(Long itfcid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysFuncinterface record, @Param("example") SysFuncinterfaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysFuncinterface record, @Param("example") SysFuncinterfaceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysFuncinterface record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_funcinterface
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysFuncinterface record);
}