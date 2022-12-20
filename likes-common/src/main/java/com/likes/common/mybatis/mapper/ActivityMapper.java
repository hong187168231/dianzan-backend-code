package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.Activity;
import com.likes.common.mybatis.entity.ActivityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int countByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int deleteByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    Activity selectOneByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    List<Activity> selectByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    Activity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Activity record);
}