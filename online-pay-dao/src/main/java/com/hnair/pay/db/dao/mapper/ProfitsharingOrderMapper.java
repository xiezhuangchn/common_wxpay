package com.hnair.pay.db.dao.mapper;

import com.hnair.pay.db.entity.ProfitsharingOrder;
import com.hnair.pay.db.entity.ProfitsharingOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfitsharingOrderMapper {
    int countByExample(ProfitsharingOrderExample example);

    int deleteByExample(ProfitsharingOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProfitsharingOrder record);

    int insertSelective(ProfitsharingOrder record);

    List<ProfitsharingOrder> selectByExample(ProfitsharingOrderExample example);

    ProfitsharingOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProfitsharingOrder record, @Param("example") ProfitsharingOrderExample example);

    int updateByExample(@Param("record") ProfitsharingOrder record, @Param("example") ProfitsharingOrderExample example);

    int updateByPrimaryKeySelective(ProfitsharingOrder record);

    int updateByPrimaryKey(ProfitsharingOrder record);
}