package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.KyKind;
import com.likes.common.mybatis.entity.KyKindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KyKindMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int countByExample(KyKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int deleteByExample(KyKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int insert(KyKind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int insertSelective(KyKind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    KyKind selectOneByExample(KyKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    List<KyKind> selectByExample(KyKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    KyKind selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") KyKind record, @Param("example") KyKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") KyKind record, @Param("example") KyKindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(KyKind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ky_kind
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(KyKind record);
}