package com.hnair.pay.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefundOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RefundOrderExample() {
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

        public Criteria andRefundOrderNoIsNull() {
            addCriterion("refund_order_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoIsNotNull() {
            addCriterion("refund_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoEqualTo(String value) {
            addCriterion("refund_order_no =", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoNotEqualTo(String value) {
            addCriterion("refund_order_no <>", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoGreaterThan(String value) {
            addCriterion("refund_order_no >", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_order_no >=", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoLessThan(String value) {
            addCriterion("refund_order_no <", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoLessThanOrEqualTo(String value) {
            addCriterion("refund_order_no <=", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoLike(String value) {
            addCriterion("refund_order_no like", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoNotLike(String value) {
            addCriterion("refund_order_no not like", value, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoIn(List<String> values) {
            addCriterion("refund_order_no in", values, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoNotIn(List<String> values) {
            addCriterion("refund_order_no not in", values, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoBetween(String value1, String value2) {
            addCriterion("refund_order_no between", value1, value2, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundOrderNoNotBetween(String value1, String value2) {
            addCriterion("refund_order_no not between", value1, value2, "refundOrderNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoIsNull() {
            addCriterion("refund_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoIsNotNull() {
            addCriterion("refund_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoEqualTo(String value) {
            addCriterion("refund_trade_no =", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoNotEqualTo(String value) {
            addCriterion("refund_trade_no <>", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoGreaterThan(String value) {
            addCriterion("refund_trade_no >", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("refund_trade_no >=", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoLessThan(String value) {
            addCriterion("refund_trade_no <", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoLessThanOrEqualTo(String value) {
            addCriterion("refund_trade_no <=", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoLike(String value) {
            addCriterion("refund_trade_no like", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoNotLike(String value) {
            addCriterion("refund_trade_no not like", value, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoIn(List<String> values) {
            addCriterion("refund_trade_no in", values, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoNotIn(List<String> values) {
            addCriterion("refund_trade_no not in", values, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoBetween(String value1, String value2) {
            addCriterion("refund_trade_no between", value1, value2, "refundTradeNo");
            return (Criteria) this;
        }

        public Criteria andRefundTradeNoNotBetween(String value1, String value2) {
            addCriterion("refund_trade_no not between", value1, value2, "refundTradeNo");
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

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<Long> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIsNull() {
            addCriterion("refund_fee is null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIsNotNull() {
            addCriterion("refund_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeEqualTo(Long value) {
            addCriterion("refund_fee =", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotEqualTo(Long value) {
            addCriterion("refund_fee <>", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeGreaterThan(Long value) {
            addCriterion("refund_fee >", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_fee >=", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLessThan(Long value) {
            addCriterion("refund_fee <", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLessThanOrEqualTo(Long value) {
            addCriterion("refund_fee <=", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIn(List<Long> values) {
            addCriterion("refund_fee in", values, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotIn(List<Long> values) {
            addCriterion("refund_fee not in", values, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeBetween(Long value1, Long value2) {
            addCriterion("refund_fee between", value1, value2, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotBetween(Long value1, Long value2) {
            addCriterion("refund_fee not between", value1, value2, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeIsNull() {
            addCriterion("refund_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeIsNotNull() {
            addCriterion("refund_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeEqualTo(String value) {
            addCriterion("refund_fee_type =", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeNotEqualTo(String value) {
            addCriterion("refund_fee_type <>", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeGreaterThan(String value) {
            addCriterion("refund_fee_type >", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_fee_type >=", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeLessThan(String value) {
            addCriterion("refund_fee_type <", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_fee_type <=", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeLike(String value) {
            addCriterion("refund_fee_type like", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeNotLike(String value) {
            addCriterion("refund_fee_type not like", value, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeIn(List<String> values) {
            addCriterion("refund_fee_type in", values, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeNotIn(List<String> values) {
            addCriterion("refund_fee_type not in", values, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeBetween(String value1, String value2) {
            addCriterion("refund_fee_type between", value1, value2, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundFeeTypeNotBetween(String value1, String value2) {
            addCriterion("refund_fee_type not between", value1, value2, "refundFeeType");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("refund_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("refund_time =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("refund_time <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("refund_time >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_time >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("refund_time <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_time <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("refund_time in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("refund_time not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("refund_time between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_time not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIsNull() {
            addCriterion("refund_reason is null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIsNotNull() {
            addCriterion("refund_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRefundReasonEqualTo(String value) {
            addCriterion("refund_reason =", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotEqualTo(String value) {
            addCriterion("refund_reason <>", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThan(String value) {
            addCriterion("refund_reason >", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonGreaterThanOrEqualTo(String value) {
            addCriterion("refund_reason >=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThan(String value) {
            addCriterion("refund_reason <", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLessThanOrEqualTo(String value) {
            addCriterion("refund_reason <=", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonLike(String value) {
            addCriterion("refund_reason like", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotLike(String value) {
            addCriterion("refund_reason not like", value, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonIn(List<String> values) {
            addCriterion("refund_reason in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotIn(List<String> values) {
            addCriterion("refund_reason not in", values, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonBetween(String value1, String value2) {
            addCriterion("refund_reason between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundReasonNotBetween(String value1, String value2) {
            addCriterion("refund_reason not between", value1, value2, "refundReason");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(Integer value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(Integer value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(Integer value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(Integer value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Integer value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<Integer> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<Integer> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(Integer value1, Integer value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andOpUserIdIsNull() {
            addCriterion("op_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOpUserIdIsNotNull() {
            addCriterion("op_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpUserIdEqualTo(String value) {
            addCriterion("op_user_id =", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdNotEqualTo(String value) {
            addCriterion("op_user_id <>", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdGreaterThan(String value) {
            addCriterion("op_user_id >", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("op_user_id >=", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdLessThan(String value) {
            addCriterion("op_user_id <", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdLessThanOrEqualTo(String value) {
            addCriterion("op_user_id <=", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdLike(String value) {
            addCriterion("op_user_id like", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdNotLike(String value) {
            addCriterion("op_user_id not like", value, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdIn(List<String> values) {
            addCriterion("op_user_id in", values, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdNotIn(List<String> values) {
            addCriterion("op_user_id not in", values, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdBetween(String value1, String value2) {
            addCriterion("op_user_id between", value1, value2, "opUserId");
            return (Criteria) this;
        }

        public Criteria andOpUserIdNotBetween(String value1, String value2) {
            addCriterion("op_user_id not between", value1, value2, "opUserId");
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

        public Criteria andCallOrderStatusIsNull() {
            addCriterion("call_order_status is null");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusIsNotNull() {
            addCriterion("call_order_status is not null");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusEqualTo(Byte value) {
            addCriterion("call_order_status =", value, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusNotEqualTo(Byte value) {
            addCriterion("call_order_status <>", value, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusGreaterThan(Byte value) {
            addCriterion("call_order_status >", value, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("call_order_status >=", value, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusLessThan(Byte value) {
            addCriterion("call_order_status <", value, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusLessThanOrEqualTo(Byte value) {
            addCriterion("call_order_status <=", value, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusIn(List<Byte> values) {
            addCriterion("call_order_status in", values, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusNotIn(List<Byte> values) {
            addCriterion("call_order_status not in", values, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusBetween(Byte value1, Byte value2) {
            addCriterion("call_order_status between", value1, value2, "callOrderStatus");
            return (Criteria) this;
        }

        public Criteria andCallOrderStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("call_order_status not between", value1, value2, "callOrderStatus");
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