package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.FivebjpksCountSgdx;
import com.likes.common.mybatis.entity.FivebjpksCountSgdxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FivebjpksCountSgdxMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int countByExample(FivebjpksCountSgdxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int deleteByExample(FivebjpksCountSgdxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int insert(FivebjpksCountSgdx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int insertSelective(FivebjpksCountSgdx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    FivebjpksCountSgdx selectOneByExample(FivebjpksCountSgdxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    List<FivebjpksCountSgdx> selectByExample(FivebjpksCountSgdxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    FivebjpksCountSgdx selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FivebjpksCountSgdx record, @Param("example") FivebjpksCountSgdxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FivebjpksCountSgdx record, @Param("example") FivebjpksCountSgdxExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FivebjpksCountSgdx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fivebjpks_count_sgdx
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FivebjpksCountSgdx record);
}