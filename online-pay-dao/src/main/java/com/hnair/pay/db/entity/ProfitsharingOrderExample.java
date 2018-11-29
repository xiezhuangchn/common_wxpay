package com.hnair.pay.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfitsharingOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProfitsharingOrderExample() {
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

        public Criteria andSharingOrderNoIsNull() {
            addCriterion("sharing_order_no is null");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoIsNotNull() {
            addCriterion("sharing_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoEqualTo(String value) {
            addCriterion("sharing_order_no =", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoNotEqualTo(String value) {
            addCriterion("sharing_order_no <>", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoGreaterThan(String value) {
            addCriterion("sharing_order_no >", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_order_no >=", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoLessThan(String value) {
            addCriterion("sharing_order_no <", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoLessThanOrEqualTo(String value) {
            addCriterion("sharing_order_no <=", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoLike(String value) {
            addCriterion("sharing_order_no like", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoNotLike(String value) {
            addCriterion("sharing_order_no not like", value, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoIn(List<String> values) {
            addCriterion("sharing_order_no in", values, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoNotIn(List<String> values) {
            addCriterion("sharing_order_no not in", values, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoBetween(String value1, String value2) {
            addCriterion("sharing_order_no between", value1, value2, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingOrderNoNotBetween(String value1, String value2) {
            addCriterion("sharing_order_no not between", value1, value2, "sharingOrderNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoIsNull() {
            addCriterion("sharing_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoIsNotNull() {
            addCriterion("sharing_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoEqualTo(String value) {
            addCriterion("sharing_trade_no =", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoNotEqualTo(String value) {
            addCriterion("sharing_trade_no <>", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoGreaterThan(String value) {
            addCriterion("sharing_trade_no >", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_trade_no >=", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoLessThan(String value) {
            addCriterion("sharing_trade_no <", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoLessThanOrEqualTo(String value) {
            addCriterion("sharing_trade_no <=", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoLike(String value) {
            addCriterion("sharing_trade_no like", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoNotLike(String value) {
            addCriterion("sharing_trade_no not like", value, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoIn(List<String> values) {
            addCriterion("sharing_trade_no in", values, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoNotIn(List<String> values) {
            addCriterion("sharing_trade_no not in", values, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoBetween(String value1, String value2) {
            addCriterion("sharing_trade_no between", value1, value2, "sharingTradeNo");
            return (Criteria) this;
        }

        public Criteria andSharingTradeNoNotBetween(String value1, String value2) {
            addCriterion("sharing_trade_no not between", value1, value2, "sharingTradeNo");
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

        public Criteria andSharingAccountTypeIsNull() {
            addCriterion("sharing_account_type is null");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeIsNotNull() {
            addCriterion("sharing_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeEqualTo(String value) {
            addCriterion("sharing_account_type =", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeNotEqualTo(String value) {
            addCriterion("sharing_account_type <>", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeGreaterThan(String value) {
            addCriterion("sharing_account_type >", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_account_type >=", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeLessThan(String value) {
            addCriterion("sharing_account_type <", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("sharing_account_type <=", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeLike(String value) {
            addCriterion("sharing_account_type like", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeNotLike(String value) {
            addCriterion("sharing_account_type not like", value, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeIn(List<String> values) {
            addCriterion("sharing_account_type in", values, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeNotIn(List<String> values) {
            addCriterion("sharing_account_type not in", values, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeBetween(String value1, String value2) {
            addCriterion("sharing_account_type between", value1, value2, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountTypeNotBetween(String value1, String value2) {
            addCriterion("sharing_account_type not between", value1, value2, "sharingAccountType");
            return (Criteria) this;
        }

        public Criteria andSharingAccountIsNull() {
            addCriterion("sharing_account is null");
            return (Criteria) this;
        }

        public Criteria andSharingAccountIsNotNull() {
            addCriterion("sharing_account is not null");
            return (Criteria) this;
        }

        public Criteria andSharingAccountEqualTo(String value) {
            addCriterion("sharing_account =", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountNotEqualTo(String value) {
            addCriterion("sharing_account <>", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountGreaterThan(String value) {
            addCriterion("sharing_account >", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_account >=", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountLessThan(String value) {
            addCriterion("sharing_account <", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountLessThanOrEqualTo(String value) {
            addCriterion("sharing_account <=", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountLike(String value) {
            addCriterion("sharing_account like", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountNotLike(String value) {
            addCriterion("sharing_account not like", value, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountIn(List<String> values) {
            addCriterion("sharing_account in", values, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountNotIn(List<String> values) {
            addCriterion("sharing_account not in", values, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountBetween(String value1, String value2) {
            addCriterion("sharing_account between", value1, value2, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingAccountNotBetween(String value1, String value2) {
            addCriterion("sharing_account not between", value1, value2, "sharingAccount");
            return (Criteria) this;
        }

        public Criteria andSharingFeeIsNull() {
            addCriterion("sharing_fee is null");
            return (Criteria) this;
        }

        public Criteria andSharingFeeIsNotNull() {
            addCriterion("sharing_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSharingFeeEqualTo(Integer value) {
            addCriterion("sharing_fee =", value, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeNotEqualTo(Integer value) {
            addCriterion("sharing_fee <>", value, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeGreaterThan(Integer value) {
            addCriterion("sharing_fee >", value, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sharing_fee >=", value, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeLessThan(Integer value) {
            addCriterion("sharing_fee <", value, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeLessThanOrEqualTo(Integer value) {
            addCriterion("sharing_fee <=", value, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeIn(List<Integer> values) {
            addCriterion("sharing_fee in", values, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeNotIn(List<Integer> values) {
            addCriterion("sharing_fee not in", values, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeBetween(Integer value1, Integer value2) {
            addCriterion("sharing_fee between", value1, value2, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("sharing_fee not between", value1, value2, "sharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeIsNull() {
            addCriterion("platform_sharing_fee is null");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeIsNotNull() {
            addCriterion("platform_sharing_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeEqualTo(Integer value) {
            addCriterion("platform_sharing_fee =", value, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeNotEqualTo(Integer value) {
            addCriterion("platform_sharing_fee <>", value, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeGreaterThan(Integer value) {
            addCriterion("platform_sharing_fee >", value, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_sharing_fee >=", value, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeLessThan(Integer value) {
            addCriterion("platform_sharing_fee <", value, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeLessThanOrEqualTo(Integer value) {
            addCriterion("platform_sharing_fee <=", value, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeIn(List<Integer> values) {
            addCriterion("platform_sharing_fee in", values, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeNotIn(List<Integer> values) {
            addCriterion("platform_sharing_fee not in", values, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeBetween(Integer value1, Integer value2) {
            addCriterion("platform_sharing_fee between", value1, value2, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andPlatformSharingFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_sharing_fee not between", value1, value2, "platformSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeIsNull() {
            addCriterion("other_sharing_fee is null");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeIsNotNull() {
            addCriterion("other_sharing_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeEqualTo(Integer value) {
            addCriterion("other_sharing_fee =", value, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeNotEqualTo(Integer value) {
            addCriterion("other_sharing_fee <>", value, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeGreaterThan(Integer value) {
            addCriterion("other_sharing_fee >", value, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_sharing_fee >=", value, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeLessThan(Integer value) {
            addCriterion("other_sharing_fee <", value, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeLessThanOrEqualTo(Integer value) {
            addCriterion("other_sharing_fee <=", value, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeIn(List<Integer> values) {
            addCriterion("other_sharing_fee in", values, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeNotIn(List<Integer> values) {
            addCriterion("other_sharing_fee not in", values, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeBetween(Integer value1, Integer value2) {
            addCriterion("other_sharing_fee between", value1, value2, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andOtherSharingFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("other_sharing_fee not between", value1, value2, "otherSharingFee");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeIsNull() {
            addCriterion("sharing_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeIsNotNull() {
            addCriterion("sharing_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeEqualTo(String value) {
            addCriterion("sharing_fee_type =", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeNotEqualTo(String value) {
            addCriterion("sharing_fee_type <>", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeGreaterThan(String value) {
            addCriterion("sharing_fee_type >", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_fee_type >=", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeLessThan(String value) {
            addCriterion("sharing_fee_type <", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("sharing_fee_type <=", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeLike(String value) {
            addCriterion("sharing_fee_type like", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeNotLike(String value) {
            addCriterion("sharing_fee_type not like", value, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeIn(List<String> values) {
            addCriterion("sharing_fee_type in", values, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeNotIn(List<String> values) {
            addCriterion("sharing_fee_type not in", values, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeBetween(String value1, String value2) {
            addCriterion("sharing_fee_type between", value1, value2, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingFeeTypeNotBetween(String value1, String value2) {
            addCriterion("sharing_fee_type not between", value1, value2, "sharingFeeType");
            return (Criteria) this;
        }

        public Criteria andSharingDescIsNull() {
            addCriterion("sharing_desc is null");
            return (Criteria) this;
        }

        public Criteria andSharingDescIsNotNull() {
            addCriterion("sharing_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSharingDescEqualTo(String value) {
            addCriterion("sharing_desc =", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescNotEqualTo(String value) {
            addCriterion("sharing_desc <>", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescGreaterThan(String value) {
            addCriterion("sharing_desc >", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_desc >=", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescLessThan(String value) {
            addCriterion("sharing_desc <", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescLessThanOrEqualTo(String value) {
            addCriterion("sharing_desc <=", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescLike(String value) {
            addCriterion("sharing_desc like", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescNotLike(String value) {
            addCriterion("sharing_desc not like", value, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescIn(List<String> values) {
            addCriterion("sharing_desc in", values, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescNotIn(List<String> values) {
            addCriterion("sharing_desc not in", values, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescBetween(String value1, String value2) {
            addCriterion("sharing_desc between", value1, value2, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingDescNotBetween(String value1, String value2) {
            addCriterion("sharing_desc not between", value1, value2, "sharingDesc");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeIsNull() {
            addCriterion("sharing_send_time is null");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeIsNotNull() {
            addCriterion("sharing_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeEqualTo(Date value) {
            addCriterion("sharing_send_time =", value, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeNotEqualTo(Date value) {
            addCriterion("sharing_send_time <>", value, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeGreaterThan(Date value) {
            addCriterion("sharing_send_time >", value, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sharing_send_time >=", value, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeLessThan(Date value) {
            addCriterion("sharing_send_time <", value, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("sharing_send_time <=", value, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeIn(List<Date> values) {
            addCriterion("sharing_send_time in", values, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeNotIn(List<Date> values) {
            addCriterion("sharing_send_time not in", values, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeBetween(Date value1, Date value2) {
            addCriterion("sharing_send_time between", value1, value2, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("sharing_send_time not between", value1, value2, "sharingSendTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeIsNull() {
            addCriterion("sharing_success_time is null");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeIsNotNull() {
            addCriterion("sharing_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeEqualTo(Date value) {
            addCriterion("sharing_success_time =", value, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeNotEqualTo(Date value) {
            addCriterion("sharing_success_time <>", value, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeGreaterThan(Date value) {
            addCriterion("sharing_success_time >", value, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sharing_success_time >=", value, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeLessThan(Date value) {
            addCriterion("sharing_success_time <", value, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("sharing_success_time <=", value, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeIn(List<Date> values) {
            addCriterion("sharing_success_time in", values, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeNotIn(List<Date> values) {
            addCriterion("sharing_success_time not in", values, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeBetween(Date value1, Date value2) {
            addCriterion("sharing_success_time between", value1, value2, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andSharingSuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("sharing_success_time not between", value1, value2, "sharingSuccessTime");
            return (Criteria) this;
        }

        public Criteria andFailureReasonIsNull() {
            addCriterion("failure_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailureReasonIsNotNull() {
            addCriterion("failure_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailureReasonEqualTo(String value) {
            addCriterion("failure_reason =", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotEqualTo(String value) {
            addCriterion("failure_reason <>", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonGreaterThan(String value) {
            addCriterion("failure_reason >", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonGreaterThanOrEqualTo(String value) {
            addCriterion("failure_reason >=", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonLessThan(String value) {
            addCriterion("failure_reason <", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonLessThanOrEqualTo(String value) {
            addCriterion("failure_reason <=", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonLike(String value) {
            addCriterion("failure_reason like", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotLike(String value) {
            addCriterion("failure_reason not like", value, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonIn(List<String> values) {
            addCriterion("failure_reason in", values, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotIn(List<String> values) {
            addCriterion("failure_reason not in", values, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonBetween(String value1, String value2) {
            addCriterion("failure_reason between", value1, value2, "failureReason");
            return (Criteria) this;
        }

        public Criteria andFailureReasonNotBetween(String value1, String value2) {
            addCriterion("failure_reason not between", value1, value2, "failureReason");
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

        public Criteria andSharingStatusIsNull() {
            addCriterion("sharing_status is null");
            return (Criteria) this;
        }

        public Criteria andSharingStatusIsNotNull() {
            addCriterion("sharing_status is not null");
            return (Criteria) this;
        }

        public Criteria andSharingStatusEqualTo(Byte value) {
            addCriterion("sharing_status =", value, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusNotEqualTo(Byte value) {
            addCriterion("sharing_status <>", value, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusGreaterThan(Byte value) {
            addCriterion("sharing_status >", value, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("sharing_status >=", value, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusLessThan(Byte value) {
            addCriterion("sharing_status <", value, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusLessThanOrEqualTo(Byte value) {
            addCriterion("sharing_status <=", value, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusIn(List<Byte> values) {
            addCriterion("sharing_status in", values, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusNotIn(List<Byte> values) {
            addCriterion("sharing_status not in", values, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusBetween(Byte value1, Byte value2) {
            addCriterion("sharing_status between", value1, value2, "sharingStatus");
            return (Criteria) this;
        }

        public Criteria andSharingStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("sharing_status not between", value1, value2, "sharingStatus");
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

        public Criteria andSharingTypeIsNull() {
            addCriterion("sharing_type is null");
            return (Criteria) this;
        }

        public Criteria andSharingTypeIsNotNull() {
            addCriterion("sharing_type is not null");
            return (Criteria) this;
        }

        public Criteria andSharingTypeEqualTo(Byte value) {
            addCriterion("sharing_type =", value, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeNotEqualTo(Byte value) {
            addCriterion("sharing_type <>", value, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeGreaterThan(Byte value) {
            addCriterion("sharing_type >", value, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("sharing_type >=", value, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeLessThan(Byte value) {
            addCriterion("sharing_type <", value, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeLessThanOrEqualTo(Byte value) {
            addCriterion("sharing_type <=", value, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeIn(List<Byte> values) {
            addCriterion("sharing_type in", values, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeNotIn(List<Byte> values) {
            addCriterion("sharing_type not in", values, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeBetween(Byte value1, Byte value2) {
            addCriterion("sharing_type between", value1, value2, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("sharing_type not between", value1, value2, "sharingType");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversIsNull() {
            addCriterion("sharing_receivers is null");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversIsNotNull() {
            addCriterion("sharing_receivers is not null");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversEqualTo(String value) {
            addCriterion("sharing_receivers =", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversNotEqualTo(String value) {
            addCriterion("sharing_receivers <>", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversGreaterThan(String value) {
            addCriterion("sharing_receivers >", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_receivers >=", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversLessThan(String value) {
            addCriterion("sharing_receivers <", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversLessThanOrEqualTo(String value) {
            addCriterion("sharing_receivers <=", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversLike(String value) {
            addCriterion("sharing_receivers like", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversNotLike(String value) {
            addCriterion("sharing_receivers not like", value, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversIn(List<String> values) {
            addCriterion("sharing_receivers in", values, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversNotIn(List<String> values) {
            addCriterion("sharing_receivers not in", values, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversBetween(String value1, String value2) {
            addCriterion("sharing_receivers between", value1, value2, "sharingReceivers");
            return (Criteria) this;
        }

        public Criteria andSharingReceiversNotBetween(String value1, String value2) {
            addCriterion("sharing_receivers not between", value1, value2, "sharingReceivers");
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