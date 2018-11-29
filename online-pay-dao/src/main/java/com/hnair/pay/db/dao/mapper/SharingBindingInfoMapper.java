package com.hnair.pay.db.dao.mapper;

import com.hnair.pay.db.entity.SharingBindingInfo;
import com.hnair.pay.db.entity.SharingBindingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SharingBindingInfoMapper {
    int countByExample(SharingBindingInfoExample example);

    int deleteByExample(SharingBindingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SharingBindingInfo record);

    int insertSelective(SharingBindingInfo record);

    List<SharingBindingInfo> selectByExample(SharingBindingInfoExample example);

    SharingBindingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SharingBindingInfo record, @Param("example") SharingBindingInfoExample example);

    int updateByExample(@Param("record") SharingBindingInfo record, @Param("example") SharingBindingInfoExample example);

    int updateByPrimaryKeySelective(SharingBindingInfo record);

    int updateByPrimaryKey(SharingBindingInfo record);
}