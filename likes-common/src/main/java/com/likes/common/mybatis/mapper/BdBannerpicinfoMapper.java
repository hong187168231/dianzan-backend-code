package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.BdBannerpicinfo;
import com.likes.common.mybatis.entity.BdBannerpicinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BdBannerpicinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int countByExample(BdBannerpicinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int deleteByExample(BdBannerpicinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long bannerpicid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int insert(BdBannerpicinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int insertSelective(BdBannerpicinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    BdBannerpicinfo selectOneByExample(BdBannerpicinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    List<BdBannerpicinfo> selectByExample(BdBannerpicinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    BdBannerpicinfo selectByPrimaryKey(Long bannerpicid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") BdBannerpicinfo record, @Param("example") BdBannerpicinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") BdBannerpicinfo record, @Param("example") BdBannerpicinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BdBannerpicinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_bannerpicinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BdBannerpicinfo record);
}