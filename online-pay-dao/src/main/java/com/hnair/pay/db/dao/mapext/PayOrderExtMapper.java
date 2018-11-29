package com.hnair.pay.db.dao.mapext;

import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.ProfitsharingOrder;

import java.util.List;
import java.util.Map;

public interface PayOrderExtMapper {

  PayOrder selectByPayOrderNoForUpdate(String busOrderNo);

  PayOrder selectByBusOrderNoForUpdate(String busOrderNo);

  List<ProfitsharingOrder> selectSharingOrderLimit(Map conditionMap);

  List<ProfitsharingOrder> selectHandingLimit(Map conditionMap);

  List<PayOrder> selectCloseOrderLimit(Map conditionMap);
}