package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.CirclePostReportType;
import com.likes.common.mybatis.entity.CirclePostReportTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CirclePostReportTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int countByExample(CirclePostReportTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int deleteByExample(CirclePostReportTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int insert(CirclePostReportType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int insertSelective(CirclePostReportType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    CirclePostReportType selectOneByExample(CirclePostReportTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    List<CirclePostReportType> selectByExample(CirclePostReportTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    CirclePostReportType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CirclePostReportType record, @Param("example") CirclePostReportTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CirclePostReportType record, @Param("example") CirclePostReportTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CirclePostReportType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table circle_post_report_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CirclePostReportType record);
}