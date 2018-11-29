package com.hnair.pay.db.dao.mapper;

import com.hnair.pay.db.entity.WithdrawOrder;
import com.hnair.pay.db.entity.WithdrawOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawOrderMapper {
    int countByExample(WithdrawOrderExample example);

    int deleteByExample(WithdrawOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WithdrawOrder record);

    int insertSelective(WithdrawOrder record);

    List<WithdrawOrder> selectByExample(WithdrawOrderExample example);

    WithdrawOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WithdrawOrder record, @Param("example") WithdrawOrderExample example);

    int updateByExample(@Param("record") WithdrawOrder record, @Param("example") WithdrawOrderExample example);

    int updateByPrimaryKeySelective(WithdrawOrder record);

    int updateByPrimaryKey(WithdrawOrder record);
}