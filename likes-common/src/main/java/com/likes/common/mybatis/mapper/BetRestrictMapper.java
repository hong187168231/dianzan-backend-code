package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.BetRestrict;
import com.likes.common.mybatis.entity.BetRestrictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BetRestrictMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int countByExample(BetRestrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int deleteByExample(BetRestrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int insert(BetRestrict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int insertSelective(BetRestrict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    BetRestrict selectOneByExample(BetRestrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    List<BetRestrict> selectByExample(BetRestrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    BetRestrict selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") BetRestrict record, @Param("example") BetRestrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") BetRestrict record, @Param("example") BetRestrictExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BetRestrict record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bet_restrict
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BetRestrict record);
}