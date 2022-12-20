package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.AgPlatform;
import com.likes.common.mybatis.entity.AgPlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgPlatformMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int countByExample(AgPlatformExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int deleteByExample(AgPlatformExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int insert(AgPlatform record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int insertSelective(AgPlatform record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    AgPlatform selectOneByExample(AgPlatformExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    List<AgPlatform> selectByExample(AgPlatformExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    AgPlatform selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgPlatform record, @Param("example") AgPlatformExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgPlatform record, @Param("example") AgPlatformExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgPlatform record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ag_platform
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgPlatform record);
}