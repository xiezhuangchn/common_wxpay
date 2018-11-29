package com.hnair.pay.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WithdrawOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoIsNull() {
            addCriterion("withdraw_order_no is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoIsNotNull() {
            addCriterion("withdraw_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoEqualTo(String value) {
            addCriterion("withdraw_order_no =", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoNotEqualTo(String value) {
            addCriterion("withdraw_order_no <>", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoGreaterThan(String value) {
            addCriterion("withdraw_order_no >", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_order_no >=", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoLessThan(String value) {
            addCriterion("withdraw_order_no <", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_order_no <=", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoLike(String value) {
            addCriterion("withdraw_order_no like", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoNotLike(String value) {
            addCriterion("withdraw_order_no not like", value, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoIn(List<String> values) {
            addCriterion("withdraw_order_no in", values, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoNotIn(List<String> values) {
            addCriterion("withdraw_order_no not in", values, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoBetween(String value1, String value2) {
            addCriterion("withdraw_order_no between", value1, value2, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawOrderNoNotBetween(String value1, String value2) {
            addCriterion("withdraw_order_no not between", value1, value2, "withdrawOrderNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoIsNull() {
            addCriterion("withdraw_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoIsNotNull() {
            addCriterion("withdraw_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoEqualTo(String value) {
            addCriterion("withdraw_trade_no =", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoNotEqualTo(String value) {
            addCriterion("withdraw_trade_no <>", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoGreaterThan(String value) {
            addCriterion("withdraw_trade_no >", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_trade_no >=", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoLessThan(String value) {
            addCriterion("withdraw_trade_no <", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoLessThanOrEqualTo(String value) {
            addCriterion("withdraw_trade_no <=", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoLike(String value) {
            addCriterion("withdraw_trade_no like", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoNotLike(String value) {
            addCriterion("withdraw_trade_no not like", value, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoIn(List<String> values) {
            addCriterion("withdraw_trade_no in", values, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoNotIn(List<String> values) {
            addCriterion("withdraw_trade_no not in", values, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoBetween(String value1, String value2) {
            addCriterion("withdraw_trade_no between", value1, value2, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andWithdrawTradeNoNotBetween(String value1, String value2) {
            addCriterion("withdraw_trade_no not between", value1, value2, "withdrawTradeNo");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdIsNull() {
            addCriterion("marketing_person_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdIsNotNull() {
            addCriterion("marketing_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdEqualTo(String value) {
            addCriterion("marketing_person_id =", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdNotEqualTo(String value) {
            addCriterion("marketing_person_id <>", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdGreaterThan(String value) {
            addCriterion("marketing_person_id >", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("marketing_person_id >=", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdLessThan(String value) {
            addCriterion("marketing_person_id <", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdLessThanOrEqualTo(String value) {
            addCriterion("marketing_person_id <=", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdLike(String value) {
            addCriterion("marketing_person_id like", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdNotLike(String value) {
            addCriterion("marketing_person_id not like", value, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdIn(List<String> values) {
            addCriterion("marketing_person_id in", values, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdNotIn(List<String> values) {
            addCriterion("marketing_person_id not in", values, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdBetween(String value1, String value2) {
            addCriterion("marketing_person_id between", value1, value2, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andMarketingPersonIdNotBetween(String value1, String value2) {
            addCriterion("marketing_person_id not between", value1, value2, "marketingPersonId");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIsNull() {
            addCriterion("withdraw_fee is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIsNotNull() {
            addCriterion("withdraw_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeEqualTo(Integer value) {
            addCriterion("withdraw_fee =", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotEqualTo(Integer value) {
            addCriterion("withdraw_fee <>", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeGreaterThan(Integer value) {
            addCriterion("withdraw_fee >", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("withdraw_fee >=", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeLessThan(Integer value) {
            addCriterion("withdraw_fee <", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeLessThanOrEqualTo(Integer value) {
            addCriterion("withdraw_fee <=", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIn(List<Integer> values) {
            addCriterion("withdraw_fee in", values, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotIn(List<Integer> values) {
            addCriterion("withdraw_fee not in", values, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_fee between", value1, value2, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("withdraw_fee not between", value1, value2, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNull() {
            addCriterion("fee_type is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(String value) {
            addCriterion("fee_type =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(String value) {
            addCriterion("fee_type <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(String value) {
            addCriterion("fee_type >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fee_type >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(String value) {
            addCriterion("fee_type <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("fee_type <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLike(String value) {
            addCriterion("fee_type like", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotLike(String value) {
            addCriterion("fee_type not like", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<String> values) {
            addCriterion("fee_type in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<String> values) {
            addCriterion("fee_type not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(String value1, String value2) {
            addCriterion("fee_type between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(String value1, String value2) {
            addCriterion("fee_type not between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andBusChannelIsNull() {
            addCriterion("bus_channel is null");
            return (Criteria) this;
        }

        public Criteria andBusChannelIsNotNull() {
            addCriterion("bus_channel is not null");
            return (Criteria) this;
        }

        public Criteria andBusChannelEqualTo(String value) {
            addCriterion("bus_channel =", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelNotEqualTo(String value) {
            addCriterion("bus_channel <>", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelGreaterThan(String value) {
            addCriterion("bus_channel >", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelGreaterThanOrEqualTo(String value) {
            addCriterion("bus_channel >=", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelLessThan(String value) {
            addCriterion("bus_channel <", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelLessThanOrEqualTo(String value) {
            addCriterion("bus_channel <=", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelLike(String value) {
            addCriterion("bus_channel like", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelNotLike(String value) {
            addCriterion("bus_channel not like", value, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelIn(List<String> values) {
            addCriterion("bus_channel in", values, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelNotIn(List<String> values) {
            addCriterion("bus_channel not in", values, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelBetween(String value1, String value2) {
            addCriterion("bus_channel between", value1, value2, "busChannel");
            return (Criteria) this;
        }

        public Criteria andBusChannelNotBetween(String value1, String value2) {
            addCriterion("bus_channel not between", value1, value2, "busChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeIsNull() {
            addCriterion("pay_channel_type is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeIsNotNull() {
            addCriterion("pay_channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeEqualTo(String value) {
            addCriterion("pay_channel_type =", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeNotEqualTo(String value) {
            addCriterion("pay_channel_type <>", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeGreaterThan(String value) {
            addCriterion("pay_channel_type >", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_channel_type >=", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeLessThan(String value) {
            addCriterion("pay_channel_type <", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_channel_type <=", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeLike(String value) {
            addCriterion("pay_channel_type like", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeNotLike(String value) {
            addCriterion("pay_channel_type not like", value, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeIn(List<String> values) {
            addCriterion("pay_channel_type in", values, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeNotIn(List<String> values) {
            addCriterion("pay_channel_type not in", values, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeBetween(String value1, String value2) {
            addCriterion("pay_channel_type between", value1, value2, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andPayChannelTypeNotBetween(String value1, String value2) {
            addCriterion("pay_channel_type not between", value1, value2, "payChannelType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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