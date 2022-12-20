package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppVersionExample implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_version
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_version
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_version
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_version
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_version
     *
     * @mbggenerated
     */
    protected Integer offset;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app_version
     *
     * @mbggenerated
     */
    protected Integer limit;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public AppVersionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
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
     * This method corresponds to the database table app_version
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
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
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
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public Integer getOffset() {
        return this.offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_version
     *
     * @mbggenerated
     */
    public AppVersionExample bound(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table app_version
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

        public Criteria andAndriodNameIsNull() {
            addCriterion("andriod_name is null");
            return (Criteria) this;
        }

        public Criteria andAndriodNameIsNotNull() {
            addCriterion("andriod_name is not null");
            return (Criteria) this;
        }

        public Criteria andAndriodNameEqualTo(String value) {
            addCriterion("andriod_name =", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameNotEqualTo(String value) {
            addCriterion("andriod_name <>", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameGreaterThan(String value) {
            addCriterion("andriod_name >", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameGreaterThanOrEqualTo(String value) {
            addCriterion("andriod_name >=", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameLessThan(String value) {
            addCriterion("andriod_name <", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameLessThanOrEqualTo(String value) {
            addCriterion("andriod_name <=", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameLike(String value) {
            addCriterion("andriod_name like", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameNotLike(String value) {
            addCriterion("andriod_name not like", value, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameIn(List<String> values) {
            addCriterion("andriod_name in", values, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameNotIn(List<String> values) {
            addCriterion("andriod_name not in", values, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameBetween(String value1, String value2) {
            addCriterion("andriod_name between", value1, value2, "andriodName");
            return (Criteria) this;
        }

        public Criteria andAndriodNameNotBetween(String value1, String value2) {
            addCriterion("andriod_name not between", value1, value2, "andriodName");
            return (Criteria) this;
        }

        public Criteria andIosNameIsNull() {
            addCriterion("ios_name is null");
            return (Criteria) this;
        }

        public Criteria andIosNameIsNotNull() {
            addCriterion("ios_name is not null");
            return (Criteria) this;
        }

        public Criteria andIosNameEqualTo(String value) {
            addCriterion("ios_name =", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameNotEqualTo(String value) {
            addCriterion("ios_name <>", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameGreaterThan(String value) {
            addCriterion("ios_name >", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameGreaterThanOrEqualTo(String value) {
            addCriterion("ios_name >=", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameLessThan(String value) {
            addCriterion("ios_name <", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameLessThanOrEqualTo(String value) {
            addCriterion("ios_name <=", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameLike(String value) {
            addCriterion("ios_name like", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameNotLike(String value) {
            addCriterion("ios_name not like", value, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameIn(List<String> values) {
            addCriterion("ios_name in", values, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameNotIn(List<String> values) {
            addCriterion("ios_name not in", values, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameBetween(String value1, String value2) {
            addCriterion("ios_name between", value1, value2, "iosName");
            return (Criteria) this;
        }

        public Criteria andIosNameNotBetween(String value1, String value2) {
            addCriterion("ios_name not between", value1, value2, "iosName");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("`number` is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("`number` is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("`number` =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("`number` <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("`number` >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("`number` >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("`number` <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("`number` <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("`number` like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("`number` not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("`number` in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("`number` not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("`number` between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("`number` not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("`size` is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("`size` is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Double value) {
            addCriterion("`size` =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Double value) {
            addCriterion("`size` <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Double value) {
            addCriterion("`size` >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("`size` >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Double value) {
            addCriterion("`size` <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Double value) {
            addCriterion("`size` <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Double> values) {
            addCriterion("`size` in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Double> values) {
            addCriterion("`size` not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Double value1, Double value2) {
            addCriterion("`size` between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Double value1, Double value2) {
            addCriterion("`size` not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNull() {
            addCriterion("notice_status is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNotNull() {
            addCriterion("notice_status is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusEqualTo(Integer value) {
            addCriterion("notice_status =", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotEqualTo(Integer value) {
            addCriterion("notice_status <>", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThan(Integer value) {
            addCriterion("notice_status >", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_status >=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThan(Integer value) {
            addCriterion("notice_status <", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("notice_status <=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIn(List<Integer> values) {
            addCriterion("notice_status in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotIn(List<Integer> values) {
            addCriterion("notice_status not in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusBetween(Integer value1, Integer value2) {
            addCriterion("notice_status between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_status not between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlIsNull() {
            addCriterion("andriod_down_url is null");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlIsNotNull() {
            addCriterion("andriod_down_url is not null");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlEqualTo(String value) {
            addCriterion("andriod_down_url =", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlNotEqualTo(String value) {
            addCriterion("andriod_down_url <>", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlGreaterThan(String value) {
            addCriterion("andriod_down_url >", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlGreaterThanOrEqualTo(String value) {
            addCriterion("andriod_down_url >=", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlLessThan(String value) {
            addCriterion("andriod_down_url <", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlLessThanOrEqualTo(String value) {
            addCriterion("andriod_down_url <=", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlLike(String value) {
            addCriterion("andriod_down_url like", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlNotLike(String value) {
            addCriterion("andriod_down_url not like", value, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlIn(List<String> values) {
            addCriterion("andriod_down_url in", values, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlNotIn(List<String> values) {
            addCriterion("andriod_down_url not in", values, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlBetween(String value1, String value2) {
            addCriterion("andriod_down_url between", value1, value2, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andAndriodDownUrlNotBetween(String value1, String value2) {
            addCriterion("andriod_down_url not between", value1, value2, "andriodDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlIsNull() {
            addCriterion("ios_down_url is null");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlIsNotNull() {
            addCriterion("ios_down_url is not null");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlEqualTo(String value) {
            addCriterion("ios_down_url =", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlNotEqualTo(String value) {
            addCriterion("ios_down_url <>", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlGreaterThan(String value) {
            addCriterion("ios_down_url >", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ios_down_url >=", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlLessThan(String value) {
            addCriterion("ios_down_url <", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlLessThanOrEqualTo(String value) {
            addCriterion("ios_down_url <=", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlLike(String value) {
            addCriterion("ios_down_url like", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlNotLike(String value) {
            addCriterion("ios_down_url not like", value, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlIn(List<String> values) {
            addCriterion("ios_down_url in", values, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlNotIn(List<String> values) {
            addCriterion("ios_down_url not in", values, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlBetween(String value1, String value2) {
            addCriterion("ios_down_url between", value1, value2, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andIosDownUrlNotBetween(String value1, String value2) {
            addCriterion("ios_down_url not between", value1, value2, "iosDownUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlIsNull() {
            addCriterion("down_url is null");
            return (Criteria) this;
        }

        public Criteria andDownUrlIsNotNull() {
            addCriterion("down_url is not null");
            return (Criteria) this;
        }

        public Criteria andDownUrlEqualTo(String value) {
            addCriterion("down_url =", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlNotEqualTo(String value) {
            addCriterion("down_url <>", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlGreaterThan(String value) {
            addCriterion("down_url >", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlGreaterThanOrEqualTo(String value) {
            addCriterion("down_url >=", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlLessThan(String value) {
            addCriterion("down_url <", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlLessThanOrEqualTo(String value) {
            addCriterion("down_url <=", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlLike(String value) {
            addCriterion("down_url like", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlNotLike(String value) {
            addCriterion("down_url not like", value, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlIn(List<String> values) {
            addCriterion("down_url in", values, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlNotIn(List<String> values) {
            addCriterion("down_url not in", values, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlBetween(String value1, String value2) {
            addCriterion("down_url between", value1, value2, "downUrl");
            return (Criteria) this;
        }

        public Criteria andDownUrlNotBetween(String value1, String value2) {
            addCriterion("down_url not between", value1, value2, "downUrl");
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

        public Criteria andAndriodSizeIsNull() {
            addCriterion("andriod_size is null");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeIsNotNull() {
            addCriterion("andriod_size is not null");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeEqualTo(Double value) {
            addCriterion("andriod_size =", value, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeNotEqualTo(Double value) {
            addCriterion("andriod_size <>", value, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeGreaterThan(Double value) {
            addCriterion("andriod_size >", value, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("andriod_size >=", value, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeLessThan(Double value) {
            addCriterion("andriod_size <", value, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeLessThanOrEqualTo(Double value) {
            addCriterion("andriod_size <=", value, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeIn(List<Double> values) {
            addCriterion("andriod_size in", values, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeNotIn(List<Double> values) {
            addCriterion("andriod_size not in", values, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeBetween(Double value1, Double value2) {
            addCriterion("andriod_size between", value1, value2, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andAndriodSizeNotBetween(Double value1, Double value2) {
            addCriterion("andriod_size not between", value1, value2, "andriodSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeIsNull() {
            addCriterion("ios_size is null");
            return (Criteria) this;
        }

        public Criteria andIosSizeIsNotNull() {
            addCriterion("ios_size is not null");
            return (Criteria) this;
        }

        public Criteria andIosSizeEqualTo(Double value) {
            addCriterion("ios_size =", value, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeNotEqualTo(Double value) {
            addCriterion("ios_size <>", value, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeGreaterThan(Double value) {
            addCriterion("ios_size >", value, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("ios_size >=", value, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeLessThan(Double value) {
            addCriterion("ios_size <", value, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeLessThanOrEqualTo(Double value) {
            addCriterion("ios_size <=", value, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeIn(List<Double> values) {
            addCriterion("ios_size in", values, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeNotIn(List<Double> values) {
            addCriterion("ios_size not in", values, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeBetween(Double value1, Double value2) {
            addCriterion("ios_size between", value1, value2, "iosSize");
            return (Criteria) this;
        }

        public Criteria andIosSizeNotBetween(Double value1, Double value2) {
            addCriterion("ios_size not between", value1, value2, "iosSize");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table app_version
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
     * This class corresponds to the database table app_version
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
