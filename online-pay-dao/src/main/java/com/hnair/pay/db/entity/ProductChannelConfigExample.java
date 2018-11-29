package com.hnair.pay.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductChannelConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductChannelConfigExample() {
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

        public Criteria andProductAppIdIsNull() {
            addCriterion("product_app_id is null");
            return (Criteria) this;
        }

        public Criteria andProductAppIdIsNotNull() {
            addCriterion("product_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductAppIdEqualTo(String value) {
            addCriterion("product_app_id =", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdNotEqualTo(String value) {
            addCriterion("product_app_id <>", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdGreaterThan(String value) {
            addCriterion("product_app_id >", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_app_id >=", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdLessThan(String value) {
            addCriterion("product_app_id <", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdLessThanOrEqualTo(String value) {
            addCriterion("product_app_id <=", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdLike(String value) {
            addCriterion("product_app_id like", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdNotLike(String value) {
            addCriterion("product_app_id not like", value, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdIn(List<String> values) {
            addCriterion("product_app_id in", values, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdNotIn(List<String> values) {
            addCriterion("product_app_id not in", values, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdBetween(String value1, String value2) {
            addCriterion("product_app_id between", value1, value2, "productAppId");
            return (Criteria) this;
        }

        public Criteria andProductAppIdNotBetween(String value1, String value2) {
            addCriterion("product_app_id not between", value1, value2, "productAppId");
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

        public Criteria andSignKeyIsNull() {
            addCriterion("sign_key is null");
            return (Criteria) this;
        }

        public Criteria andSignKeyIsNotNull() {
            addCriterion("sign_key is not null");
            return (Criteria) this;
        }

        public Criteria andSignKeyEqualTo(String value) {
            addCriterion("sign_key =", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotEqualTo(String value) {
            addCriterion("sign_key <>", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyGreaterThan(String value) {
            addCriterion("sign_key >", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sign_key >=", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyLessThan(String value) {
            addCriterion("sign_key <", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyLessThanOrEqualTo(String value) {
            addCriterion("sign_key <=", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyLike(String value) {
            addCriterion("sign_key like", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotLike(String value) {
            addCriterion("sign_key not like", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyIn(List<String> values) {
            addCriterion("sign_key in", values, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotIn(List<String> values) {
            addCriterion("sign_key not in", values, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyBetween(String value1, String value2) {
            addCriterion("sign_key between", value1, value2, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotBetween(String value1, String value2) {
            addCriterion("sign_key not between", value1, value2, "signKey");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNull() {
            addCriterion("pay_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNotNull() {
            addCriterion("pay_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlEqualTo(String value) {
            addCriterion("pay_notify_url =", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotEqualTo(String value) {
            addCriterion("pay_notify_url <>", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThan(String value) {
            addCriterion("pay_notify_url >", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pay_notify_url >=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThan(String value) {
            addCriterion("pay_notify_url <", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("pay_notify_url <=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLike(String value) {
            addCriterion("pay_notify_url like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotLike(String value) {
            addCriterion("pay_notify_url not like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIn(List<String> values) {
            addCriterion("pay_notify_url in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotIn(List<String> values) {
            addCriterion("pay_notify_url not in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlBetween(String value1, String value2) {
            addCriterion("pay_notify_url between", value1, value2, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("pay_notify_url not between", value1, value2, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlIsNull() {
            addCriterion("refund_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlIsNotNull() {
            addCriterion("refund_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlEqualTo(String value) {
            addCriterion("refund_notify_url =", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotEqualTo(String value) {
            addCriterion("refund_notify_url <>", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlGreaterThan(String value) {
            addCriterion("refund_notify_url >", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("refund_notify_url >=", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlLessThan(String value) {
            addCriterion("refund_notify_url <", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("refund_notify_url <=", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlLike(String value) {
            addCriterion("refund_notify_url like", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotLike(String value) {
            addCriterion("refund_notify_url not like", value, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlIn(List<String> values) {
            addCriterion("refund_notify_url in", values, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotIn(List<String> values) {
            addCriterion("refund_notify_url not in", values, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlBetween(String value1, String value2) {
            addCriterion("refund_notify_url between", value1, value2, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("refund_notify_url not between", value1, value2, "refundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlIsNull() {
            addCriterion("sharing_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlIsNotNull() {
            addCriterion("sharing_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlEqualTo(String value) {
            addCriterion("sharing_notify_url =", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlNotEqualTo(String value) {
            addCriterion("sharing_notify_url <>", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlGreaterThan(String value) {
            addCriterion("sharing_notify_url >", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sharing_notify_url >=", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlLessThan(String value) {
            addCriterion("sharing_notify_url <", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("sharing_notify_url <=", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlLike(String value) {
            addCriterion("sharing_notify_url like", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlNotLike(String value) {
            addCriterion("sharing_notify_url not like", value, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlIn(List<String> values) {
            addCriterion("sharing_notify_url in", values, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlNotIn(List<String> values) {
            addCriterion("sharing_notify_url not in", values, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlBetween(String value1, String value2) {
            addCriterion("sharing_notify_url between", value1, value2, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andSharingNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("sharing_notify_url not between", value1, value2, "sharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlIsNull() {
            addCriterion("huidu_pay_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlIsNotNull() {
            addCriterion("huidu_pay_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlEqualTo(String value) {
            addCriterion("huidu_pay_notify_url =", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlNotEqualTo(String value) {
            addCriterion("huidu_pay_notify_url <>", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlGreaterThan(String value) {
            addCriterion("huidu_pay_notify_url >", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("huidu_pay_notify_url >=", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlLessThan(String value) {
            addCriterion("huidu_pay_notify_url <", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("huidu_pay_notify_url <=", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlLike(String value) {
            addCriterion("huidu_pay_notify_url like", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlNotLike(String value) {
            addCriterion("huidu_pay_notify_url not like", value, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlIn(List<String> values) {
            addCriterion("huidu_pay_notify_url in", values, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlNotIn(List<String> values) {
            addCriterion("huidu_pay_notify_url not in", values, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlBetween(String value1, String value2) {
            addCriterion("huidu_pay_notify_url between", value1, value2, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduPayNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("huidu_pay_notify_url not between", value1, value2, "huiduPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlIsNull() {
            addCriterion("huidu_refund_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlIsNotNull() {
            addCriterion("huidu_refund_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlEqualTo(String value) {
            addCriterion("huidu_refund_notify_url =", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlNotEqualTo(String value) {
            addCriterion("huidu_refund_notify_url <>", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlGreaterThan(String value) {
            addCriterion("huidu_refund_notify_url >", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("huidu_refund_notify_url >=", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlLessThan(String value) {
            addCriterion("huidu_refund_notify_url <", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("huidu_refund_notify_url <=", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlLike(String value) {
            addCriterion("huidu_refund_notify_url like", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlNotLike(String value) {
            addCriterion("huidu_refund_notify_url not like", value, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlIn(List<String> values) {
            addCriterion("huidu_refund_notify_url in", values, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlNotIn(List<String> values) {
            addCriterion("huidu_refund_notify_url not in", values, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlBetween(String value1, String value2) {
            addCriterion("huidu_refund_notify_url between", value1, value2, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduRefundNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("huidu_refund_notify_url not between", value1, value2, "huiduRefundNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlIsNull() {
            addCriterion("huidu_sharing_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlIsNotNull() {
            addCriterion("huidu_sharing_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlEqualTo(String value) {
            addCriterion("huidu_sharing_notify_url =", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlNotEqualTo(String value) {
            addCriterion("huidu_sharing_notify_url <>", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlGreaterThan(String value) {
            addCriterion("huidu_sharing_notify_url >", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("huidu_sharing_notify_url >=", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlLessThan(String value) {
            addCriterion("huidu_sharing_notify_url <", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("huidu_sharing_notify_url <=", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlLike(String value) {
            addCriterion("huidu_sharing_notify_url like", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlNotLike(String value) {
            addCriterion("huidu_sharing_notify_url not like", value, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlIn(List<String> values) {
            addCriterion("huidu_sharing_notify_url in", values, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlNotIn(List<String> values) {
            addCriterion("huidu_sharing_notify_url not in", values, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlBetween(String value1, String value2) {
            addCriterion("huidu_sharing_notify_url between", value1, value2, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andHuiduSharingNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("huidu_sharing_notify_url not between", value1, value2, "huiduSharingNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
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