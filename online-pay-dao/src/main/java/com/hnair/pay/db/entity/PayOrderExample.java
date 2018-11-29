package com.hnair.pay.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayOrderExample() {
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

        public Criteria andBusPayNoIsNull() {
            addCriterion("bus_pay_no is null");
            return (Criteria) this;
        }

        public Criteria andBusPayNoIsNotNull() {
            addCriterion("bus_pay_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusPayNoEqualTo(String value) {
            addCriterion("bus_pay_no =", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoNotEqualTo(String value) {
            addCriterion("bus_pay_no <>", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoGreaterThan(String value) {
            addCriterion("bus_pay_no >", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoGreaterThanOrEqualTo(String value) {
            addCriterion("bus_pay_no >=", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoLessThan(String value) {
            addCriterion("bus_pay_no <", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoLessThanOrEqualTo(String value) {
            addCriterion("bus_pay_no <=", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoLike(String value) {
            addCriterion("bus_pay_no like", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoNotLike(String value) {
            addCriterion("bus_pay_no not like", value, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoIn(List<String> values) {
            addCriterion("bus_pay_no in", values, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoNotIn(List<String> values) {
            addCriterion("bus_pay_no not in", values, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoBetween(String value1, String value2) {
            addCriterion("bus_pay_no between", value1, value2, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andBusPayNoNotBetween(String value1, String value2) {
            addCriterion("bus_pay_no not between", value1, value2, "busPayNo");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIsNull() {
            addCriterion("prepay_id is null");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIsNotNull() {
            addCriterion("prepay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayIdEqualTo(String value) {
            addCriterion("prepay_id =", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotEqualTo(String value) {
            addCriterion("prepay_id <>", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdGreaterThan(String value) {
            addCriterion("prepay_id >", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdGreaterThanOrEqualTo(String value) {
            addCriterion("prepay_id >=", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLessThan(String value) {
            addCriterion("prepay_id <", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLessThanOrEqualTo(String value) {
            addCriterion("prepay_id <=", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLike(String value) {
            addCriterion("prepay_id like", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotLike(String value) {
            addCriterion("prepay_id not like", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIn(List<String> values) {
            addCriterion("prepay_id in", values, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotIn(List<String> values) {
            addCriterion("prepay_id not in", values, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdBetween(String value1, String value2) {
            addCriterion("prepay_id between", value1, value2, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotBetween(String value1, String value2) {
            addCriterion("prepay_id not between", value1, value2, "prepayId");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoIsNull() {
            addCriterion("bus_order_no is null");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoIsNotNull() {
            addCriterion("bus_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoEqualTo(String value) {
            addCriterion("bus_order_no =", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoNotEqualTo(String value) {
            addCriterion("bus_order_no <>", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoGreaterThan(String value) {
            addCriterion("bus_order_no >", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("bus_order_no >=", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoLessThan(String value) {
            addCriterion("bus_order_no <", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoLessThanOrEqualTo(String value) {
            addCriterion("bus_order_no <=", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoLike(String value) {
            addCriterion("bus_order_no like", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoNotLike(String value) {
            addCriterion("bus_order_no not like", value, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoIn(List<String> values) {
            addCriterion("bus_order_no in", values, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoNotIn(List<String> values) {
            addCriterion("bus_order_no not in", values, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoBetween(String value1, String value2) {
            addCriterion("bus_order_no between", value1, value2, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusOrderNoNotBetween(String value1, String value2) {
            addCriterion("bus_order_no not between", value1, value2, "busOrderNo");
            return (Criteria) this;
        }

        public Criteria andBusTypeIsNull() {
            addCriterion("bus_type is null");
            return (Criteria) this;
        }

        public Criteria andBusTypeIsNotNull() {
            addCriterion("bus_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusTypeEqualTo(String value) {
            addCriterion("bus_type =", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotEqualTo(String value) {
            addCriterion("bus_type <>", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThan(String value) {
            addCriterion("bus_type >", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bus_type >=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThan(String value) {
            addCriterion("bus_type <", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThanOrEqualTo(String value) {
            addCriterion("bus_type <=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLike(String value) {
            addCriterion("bus_type like", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotLike(String value) {
            addCriterion("bus_type not like", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeIn(List<String> values) {
            addCriterion("bus_type in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotIn(List<String> values) {
            addCriterion("bus_type not in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeBetween(String value1, String value2) {
            addCriterion("bus_type between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotBetween(String value1, String value2) {
            addCriterion("bus_type not between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Integer value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Integer value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Integer value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Integer value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Integer value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Integer> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Integer> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Integer value1, Integer value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTradePayNoIsNull() {
            addCriterion("trade_pay_no is null");
            return (Criteria) this;
        }

        public Criteria andTradePayNoIsNotNull() {
            addCriterion("trade_pay_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradePayNoEqualTo(String value) {
            addCriterion("trade_pay_no =", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoNotEqualTo(String value) {
            addCriterion("trade_pay_no <>", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoGreaterThan(String value) {
            addCriterion("trade_pay_no >", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_pay_no >=", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoLessThan(String value) {
            addCriterion("trade_pay_no <", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoLessThanOrEqualTo(String value) {
            addCriterion("trade_pay_no <=", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoLike(String value) {
            addCriterion("trade_pay_no like", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoNotLike(String value) {
            addCriterion("trade_pay_no not like", value, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoIn(List<String> values) {
            addCriterion("trade_pay_no in", values, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoNotIn(List<String> values) {
            addCriterion("trade_pay_no not in", values, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoBetween(String value1, String value2) {
            addCriterion("trade_pay_no between", value1, value2, "tradePayNo");
            return (Criteria) this;
        }

        public Criteria andTradePayNoNotBetween(String value1, String value2) {
            addCriterion("trade_pay_no not between", value1, value2, "tradePayNo");
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

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(Byte value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(Byte value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(Byte value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(Byte value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<Byte> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<Byte> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(Byte value1, Byte value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIsNull() {
            addCriterion("pay_success_time is null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIsNotNull() {
            addCriterion("pay_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeEqualTo(Date value) {
            addCriterion("pay_success_time =", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotEqualTo(Date value) {
            addCriterion("pay_success_time <>", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeGreaterThan(Date value) {
            addCriterion("pay_success_time >", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_success_time >=", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeLessThan(Date value) {
            addCriterion("pay_success_time <", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_success_time <=", value, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeIn(List<Date> values) {
            addCriterion("pay_success_time in", values, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotIn(List<Date> values) {
            addCriterion("pay_success_time not in", values, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeBetween(Date value1, Date value2) {
            addCriterion("pay_success_time between", value1, value2, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPaySuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_success_time not between", value1, value2, "paySuccessTime");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Byte value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Byte value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Byte value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Byte value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Byte value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Byte> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Byte> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Byte value1, Byte value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIsNull() {
            addCriterion("wx_open_id is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIsNotNull() {
            addCriterion("wx_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdEqualTo(String value) {
            addCriterion("wx_open_id =", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotEqualTo(String value) {
            addCriterion("wx_open_id <>", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdGreaterThan(String value) {
            addCriterion("wx_open_id >", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_open_id >=", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLessThan(String value) {
            addCriterion("wx_open_id <", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLessThanOrEqualTo(String value) {
            addCriterion("wx_open_id <=", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLike(String value) {
            addCriterion("wx_open_id like", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotLike(String value) {
            addCriterion("wx_open_id not like", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIn(List<String> values) {
            addCriterion("wx_open_id in", values, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotIn(List<String> values) {
            addCriterion("wx_open_id not in", values, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdBetween(String value1, String value2) {
            addCriterion("wx_open_id between", value1, value2, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotBetween(String value1, String value2) {
            addCriterion("wx_open_id not between", value1, value2, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(String value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(String value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(String value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(String value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(String value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLike(String value) {
            addCriterion("hotel_id like", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotLike(String value) {
            addCriterion("hotel_id not like", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<String> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<String> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(String value1, String value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(String value1, String value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdIsNull() {
            addCriterion("sub_app_id is null");
            return (Criteria) this;
        }

        public Criteria andSubAppIdIsNotNull() {
            addCriterion("sub_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubAppIdEqualTo(String value) {
            addCriterion("sub_app_id =", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdNotEqualTo(String value) {
            addCriterion("sub_app_id <>", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdGreaterThan(String value) {
            addCriterion("sub_app_id >", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_app_id >=", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdLessThan(String value) {
            addCriterion("sub_app_id <", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdLessThanOrEqualTo(String value) {
            addCriterion("sub_app_id <=", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdLike(String value) {
            addCriterion("sub_app_id like", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdNotLike(String value) {
            addCriterion("sub_app_id not like", value, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdIn(List<String> values) {
            addCriterion("sub_app_id in", values, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdNotIn(List<String> values) {
            addCriterion("sub_app_id not in", values, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdBetween(String value1, String value2) {
            addCriterion("sub_app_id between", value1, value2, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubAppIdNotBetween(String value1, String value2) {
            addCriterion("sub_app_id not between", value1, value2, "subAppId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdIsNull() {
            addCriterion("sub_mch_id is null");
            return (Criteria) this;
        }

        public Criteria andSubMchIdIsNotNull() {
            addCriterion("sub_mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubMchIdEqualTo(String value) {
            addCriterion("sub_mch_id =", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotEqualTo(String value) {
            addCriterion("sub_mch_id <>", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdGreaterThan(String value) {
            addCriterion("sub_mch_id >", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_mch_id >=", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdLessThan(String value) {
            addCriterion("sub_mch_id <", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdLessThanOrEqualTo(String value) {
            addCriterion("sub_mch_id <=", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdLike(String value) {
            addCriterion("sub_mch_id like", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotLike(String value) {
            addCriterion("sub_mch_id not like", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdIn(List<String> values) {
            addCriterion("sub_mch_id in", values, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotIn(List<String> values) {
            addCriterion("sub_mch_id not in", values, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdBetween(String value1, String value2) {
            addCriterion("sub_mch_id between", value1, value2, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotBetween(String value1, String value2) {
            addCriterion("sub_mch_id not between", value1, value2, "subMchId");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderIsNull() {
            addCriterion("is_sharing_order is null");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderIsNotNull() {
            addCriterion("is_sharing_order is not null");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderEqualTo(String value) {
            addCriterion("is_sharing_order =", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderNotEqualTo(String value) {
            addCriterion("is_sharing_order <>", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderGreaterThan(String value) {
            addCriterion("is_sharing_order >", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderGreaterThanOrEqualTo(String value) {
            addCriterion("is_sharing_order >=", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderLessThan(String value) {
            addCriterion("is_sharing_order <", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderLessThanOrEqualTo(String value) {
            addCriterion("is_sharing_order <=", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderLike(String value) {
            addCriterion("is_sharing_order like", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderNotLike(String value) {
            addCriterion("is_sharing_order not like", value, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderIn(List<String> values) {
            addCriterion("is_sharing_order in", values, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderNotIn(List<String> values) {
            addCriterion("is_sharing_order not in", values, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderBetween(String value1, String value2) {
            addCriterion("is_sharing_order between", value1, value2, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andIsSharingOrderNotBetween(String value1, String value2) {
            addCriterion("is_sharing_order not between", value1, value2, "isSharingOrder");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNull() {
            addCriterion("send_status is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("send_status is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(Byte value) {
            addCriterion("send_status =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(Byte value) {
            addCriterion("send_status <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(Byte value) {
            addCriterion("send_status >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_status >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(Byte value) {
            addCriterion("send_status <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(Byte value) {
            addCriterion("send_status <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<Byte> values) {
            addCriterion("send_status in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<Byte> values) {
            addCriterion("send_status not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(Byte value1, Byte value2) {
            addCriterion("send_status between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("send_status not between", value1, value2, "sendStatus");
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