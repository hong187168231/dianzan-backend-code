package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreeStrongWayDsExample implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    protected Integer offset;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    protected Integer limit;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public ThreeStrongWayDsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        offset = null;
        limit = null;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public Integer getOffset() {
        return this.offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public ThreeStrongWayDsExample bound(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("`year` is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("`year` is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("`year` =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("`year` <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("`year` >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("`year` >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("`year` <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("`year` <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("`year` like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("`year` not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("`year` in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("`year` not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("`year` between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("`year` not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andIssueIsNull() {
            addCriterion("issue is null");
            return (Criteria) this;
        }

        public Criteria andIssueIsNotNull() {
            addCriterion("issue is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEqualTo(String value) {
            addCriterion("issue =", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotEqualTo(String value) {
            addCriterion("issue <>", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThan(String value) {
            addCriterion("issue >", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThanOrEqualTo(String value) {
            addCriterion("issue >=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThan(String value) {
            addCriterion("issue <", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThanOrEqualTo(String value) {
            addCriterion("issue <=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLike(String value) {
            addCriterion("issue like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotLike(String value) {
            addCriterion("issue not like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueIn(List<String> values) {
            addCriterion("issue in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotIn(List<String> values) {
            addCriterion("issue not in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueBetween(String value1, String value2) {
            addCriterion("issue between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotBetween(String value1, String value2) {
            addCriterion("issue not between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andNumTypeIsNull() {
            addCriterion("num_type is null");
            return (Criteria) this;
        }

        public Criteria andNumTypeIsNotNull() {
            addCriterion("num_type is not null");
            return (Criteria) this;
        }

        public Criteria andNumTypeEqualTo(Integer value) {
            addCriterion("num_type =", value, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeNotEqualTo(Integer value) {
            addCriterion("num_type <>", value, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeGreaterThan(Integer value) {
            addCriterion("num_type >", value, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_type >=", value, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeLessThan(Integer value) {
            addCriterion("num_type <", value, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeLessThanOrEqualTo(Integer value) {
            addCriterion("num_type <=", value, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeIn(List<Integer> values) {
            addCriterion("num_type in", values, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeNotIn(List<Integer> values) {
            addCriterion("num_type not in", values, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeBetween(Integer value1, Integer value2) {
            addCriterion("num_type between", value1, value2, "numType");
            return (Criteria) this;
        }

        public Criteria andNumTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("num_type not between", value1, value2, "numType");
            return (Criteria) this;
        }

        public Criteria andBigkIsNull() {
            addCriterion("bigK is null");
            return (Criteria) this;
        }

        public Criteria andBigkIsNotNull() {
            addCriterion("bigK is not null");
            return (Criteria) this;
        }

        public Criteria andBigkEqualTo(Integer value) {
            addCriterion("bigK =", value, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkNotEqualTo(Integer value) {
            addCriterion("bigK <>", value, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkGreaterThan(Integer value) {
            addCriterion("bigK >", value, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigK >=", value, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkLessThan(Integer value) {
            addCriterion("bigK <", value, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkLessThanOrEqualTo(Integer value) {
            addCriterion("bigK <=", value, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkIn(List<Integer> values) {
            addCriterion("bigK in", values, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkNotIn(List<Integer> values) {
            addCriterion("bigK not in", values, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkBetween(Integer value1, Integer value2) {
            addCriterion("bigK between", value1, value2, "bigk");
            return (Criteria) this;
        }

        public Criteria andBigkNotBetween(Integer value1, Integer value2) {
            addCriterion("bigK not between", value1, value2, "bigk");
            return (Criteria) this;
        }

        public Criteria andBiglIsNull() {
            addCriterion("bigL is null");
            return (Criteria) this;
        }

        public Criteria andBiglIsNotNull() {
            addCriterion("bigL is not null");
            return (Criteria) this;
        }

        public Criteria andBiglEqualTo(Integer value) {
            addCriterion("bigL =", value, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglNotEqualTo(Integer value) {
            addCriterion("bigL <>", value, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglGreaterThan(Integer value) {
            addCriterion("bigL >", value, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigL >=", value, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglLessThan(Integer value) {
            addCriterion("bigL <", value, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglLessThanOrEqualTo(Integer value) {
            addCriterion("bigL <=", value, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglIn(List<Integer> values) {
            addCriterion("bigL in", values, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglNotIn(List<Integer> values) {
            addCriterion("bigL not in", values, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglBetween(Integer value1, Integer value2) {
            addCriterion("bigL between", value1, value2, "bigl");
            return (Criteria) this;
        }

        public Criteria andBiglNotBetween(Integer value1, Integer value2) {
            addCriterion("bigL not between", value1, value2, "bigl");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagIsNull() {
            addCriterion("rule_two_flag is null");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagIsNotNull() {
            addCriterion("rule_two_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagEqualTo(Integer value) {
            addCriterion("rule_two_flag =", value, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagNotEqualTo(Integer value) {
            addCriterion("rule_two_flag <>", value, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagGreaterThan(Integer value) {
            addCriterion("rule_two_flag >", value, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_two_flag >=", value, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagLessThan(Integer value) {
            addCriterion("rule_two_flag <", value, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagLessThanOrEqualTo(Integer value) {
            addCriterion("rule_two_flag <=", value, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagIn(List<Integer> values) {
            addCriterion("rule_two_flag in", values, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagNotIn(List<Integer> values) {
            addCriterion("rule_two_flag not in", values, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagBetween(Integer value1, Integer value2) {
            addCriterion("rule_two_flag between", value1, value2, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleTwoFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_two_flag not between", value1, value2, "ruleTwoFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagIsNull() {
            addCriterion("rule_three_flag is null");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagIsNotNull() {
            addCriterion("rule_three_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagEqualTo(Integer value) {
            addCriterion("rule_three_flag =", value, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagNotEqualTo(Integer value) {
            addCriterion("rule_three_flag <>", value, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagGreaterThan(Integer value) {
            addCriterion("rule_three_flag >", value, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_three_flag >=", value, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagLessThan(Integer value) {
            addCriterion("rule_three_flag <", value, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagLessThanOrEqualTo(Integer value) {
            addCriterion("rule_three_flag <=", value, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagIn(List<Integer> values) {
            addCriterion("rule_three_flag in", values, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagNotIn(List<Integer> values) {
            addCriterion("rule_three_flag not in", values, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagBetween(Integer value1, Integer value2) {
            addCriterion("rule_three_flag between", value1, value2, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andRuleThreeFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_three_flag not between", value1, value2, "ruleThreeFlag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table three_strong_way_ds
     *
     * @mbggenerated
     */
    public static class Criterion implements Serializable {
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
