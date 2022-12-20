package com.likes.common.mybatis.mapper;

import com.likes.common.mybatis.entity.DbGame;
import com.likes.common.mybatis.entity.DbGameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbGameMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int countByExample(DbGameExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int deleteByExample(DbGameExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int insert(DbGame record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int insertSelective(DbGame record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    DbGame selectOneByExample(DbGameExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    List<DbGame> selectByExample(DbGameExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    DbGame selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DbGame record, @Param("example") DbGameExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DbGame record, @Param("example") DbGameExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DbGame record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table db_game
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DbGame record);
}