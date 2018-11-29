package com.hnair.pay.db.dao.mapper;

import com.hnair.pay.db.entity.RefundOrder;
import com.hnair.pay.db.entity.RefundOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundOrderMapper {
    int countByExample(RefundOrderExample example);

    int deleteByExample(RefundOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RefundOrder record);

    int insertSelective(RefundOrder record);

    List<RefundOrder> selectByExample(RefundOrderExample example);

    RefundOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RefundOrder record, @Param("example") RefundOrderExample example);

    int updateByExample(@Param("record") RefundOrder record, @Param("example") RefundOrderExample example);

    int updateByPrimaryKeySelective(RefundOrder record);

    int updateByPrimaryKey(RefundOrder record);
}