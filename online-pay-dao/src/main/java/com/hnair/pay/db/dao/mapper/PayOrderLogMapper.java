package com.hnair.pay.db.dao.mapper;

import com.hnair.pay.db.entity.PayOrderLog;
import com.hnair.pay.db.entity.PayOrderLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOrderLogMapper {
    int countByExample(PayOrderLogExample example);

    int deleteByExample(PayOrderLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayOrderLog record);

    int insertSelective(PayOrderLog record);

    List<PayOrderLog> selectByExample(PayOrderLogExample example);

    PayOrderLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayOrderLog record, @Param("example") PayOrderLogExample example);

    int updateByExample(@Param("record") PayOrderLog record, @Param("example") PayOrderLogExample example);

    int updateByPrimaryKeySelective(PayOrderLog record);

    int updateByPrimaryKey(PayOrderLog record);
}