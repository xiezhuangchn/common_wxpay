package com.hnair.pay.db.dao.mapper;

import com.hnair.pay.db.entity.PayOrder;
import com.hnair.pay.db.entity.PayOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOrderMapper {
    int countByExample(PayOrderExample example);

    int deleteByExample(PayOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayOrder record);

    int insertSelective(PayOrder record);

    List<PayOrder> selectByExample(PayOrderExample example);

    PayOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayOrder record, @Param("example") PayOrderExample example);

    int updateByExample(@Param("record") PayOrder record, @Param("example") PayOrderExample example);

    int updateByPrimaryKeySelective(PayOrder record);

    int updateByPrimaryKey(PayOrder record);
}