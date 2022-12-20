package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.AdSite;
import com.likes.common.mybatis.entity.AdSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdSiteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int countByExample(AdSiteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int deleteByExample(AdSiteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int insert(AdSite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int insertSelective(AdSite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    AdSite selectOneByExample(AdSiteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    List<AdSite> selectByExample(AdSiteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    AdSite selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdSite record, @Param("example") AdSiteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdSite record, @Param("example") AdSiteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdSite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_site
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdSite record);
}