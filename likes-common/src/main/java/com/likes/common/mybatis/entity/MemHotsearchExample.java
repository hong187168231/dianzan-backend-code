package com.likes.common.mybatis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemHotsearchExample implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    protected Integer offset;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    protected Integer limit;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public MemHotsearchExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
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
     * This method corresponds to the database table mem_hotsearch
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
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
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
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public Integer getOffset() {
        return this.offset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mem_hotsearch
     *
     * @mbggenerated
     */
    public MemHotsearchExample bound(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mem_hotsearch
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

        public Criteria andSearchidIsNull() {
            addCriterion("searchid is null");
            return (Criteria) this;
        }

        public Criteria andSearchidIsNotNull() {
            addCriterion("searchid is not null");
            return (Criteria) this;
        }

        public Criteria andSearchidEqualTo(Long value) {
            addCriterion("searchid =", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotEqualTo(Long value) {
            addCriterion("searchid <>", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidGreaterThan(Long value) {
            addCriterion("searchid >", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidGreaterThanOrEqualTo(Long value) {
            addCriterion("searchid >=", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidLessThan(Long value) {
            addCriterion("searchid <", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidLessThanOrEqualTo(Long value) {
            addCriterion("searchid <=", value, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidIn(List<Long> values) {
            addCriterion("searchid in", values, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotIn(List<Long> values) {
            addCriterion("searchid not in", values, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidBetween(Long value1, Long value2) {
            addCriterion("searchid between", value1, value2, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchidNotBetween(Long value1, Long value2) {
            addCriterion("searchid not between", value1, value2, "searchid");
            return (Criteria) this;
        }

        public Criteria andSearchnameIsNull() {
            addCriterion("searchname is null");
            return (Criteria) this;
        }

        public Criteria andSearchnameIsNotNull() {
            addCriterion("searchname is not null");
            return (Criteria) this;
        }

        public Criteria andSearchnameEqualTo(String value) {
            addCriterion("searchname =", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameNotEqualTo(String value) {
            addCriterion("searchname <>", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameGreaterThan(String value) {
            addCriterion("searchname >", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameGreaterThanOrEqualTo(String value) {
            addCriterion("searchname >=", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameLessThan(String value) {
            addCriterion("searchname <", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameLessThanOrEqualTo(String value) {
            addCriterion("searchname <=", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameLike(String value) {
            addCriterion("searchname like", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameNotLike(String value) {
            addCriterion("searchname not like", value, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameIn(List<String> values) {
            addCriterion("searchname in", values, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameNotIn(List<String> values) {
            addCriterion("searchname not in", values, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameBetween(String value1, String value2) {
            addCriterion("searchname between", value1, value2, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchnameNotBetween(String value1, String value2) {
            addCriterion("searchname not between", value1, value2, "searchname");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIsNull() {
            addCriterion("searchtype is null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIsNotNull() {
            addCriterion("searchtype is not null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeEqualTo(Integer value) {
            addCriterion("searchtype =", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotEqualTo(Integer value) {
            addCriterion("searchtype <>", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThan(Integer value) {
            addCriterion("searchtype >", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("searchtype >=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThan(Integer value) {
            addCriterion("searchtype <", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThanOrEqualTo(Integer value) {
            addCriterion("searchtype <=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIn(List<Integer> values) {
            addCriterion("searchtype in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotIn(List<Integer> values) {
            addCriterion("searchtype not in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeBetween(Integer value1, Integer value2) {
            addCriterion("searchtype between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("searchtype not between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchnumsIsNull() {
            addCriterion("searchnums is null");
            return (Criteria) this;
        }

        public Criteria andSearchnumsIsNotNull() {
            addCriterion("searchnums is not null");
            return (Criteria) this;
        }

        public Criteria andSearchnumsEqualTo(Long value) {
            addCriterion("searchnums =", value, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsNotEqualTo(Long value) {
            addCriterion("searchnums <>", value, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsGreaterThan(Long value) {
            addCriterion("searchnums >", value, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsGreaterThanOrEqualTo(Long value) {
            addCriterion("searchnums >=", value, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsLessThan(Long value) {
            addCriterion("searchnums <", value, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsLessThanOrEqualTo(Long value) {
            addCriterion("searchnums <=", value, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsIn(List<Long> values) {
            addCriterion("searchnums in", values, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsNotIn(List<Long> values) {
            addCriterion("searchnums not in", values, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsBetween(Long value1, Long value2) {
            addCriterion("searchnums between", value1, value2, "searchnums");
            return (Criteria) this;
        }

        public Criteria andSearchnumsNotBetween(Long value1, Long value2) {
            addCriterion("searchnums not between", value1, value2, "searchnums");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mem_hotsearch
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
     * This class corresponds to the database table mem_hotsearch
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
