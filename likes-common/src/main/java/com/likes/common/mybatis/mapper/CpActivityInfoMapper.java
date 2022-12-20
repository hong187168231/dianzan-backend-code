package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.CpActivityInfo;
import com.likes.common.mybatis.entity.CpActivityInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpActivityInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int countByExample(CpActivityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int deleteByExample(CpActivityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int insert(CpActivityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int insertSelective(CpActivityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    CpActivityInfo selectOneByExample(CpActivityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    List<CpActivityInfo> selectByExample(CpActivityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    CpActivityInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CpActivityInfo record, @Param("example") CpActivityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CpActivityInfo record, @Param("example") CpActivityInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CpActivityInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cp_activity_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CpActivityInfo record);
}