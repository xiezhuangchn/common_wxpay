package com.hnair.pay.db.dao.mapper;

import com.hnair.pay.db.entity.ProductChannelConfig;
import com.hnair.pay.db.entity.ProductChannelConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductChannelConfigMapper {
    int countByExample(ProductChannelConfigExample example);

    int deleteByExample(ProductChannelConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductChannelConfig record);

    int insertSelective(ProductChannelConfig record);

    List<ProductChannelConfig> selectByExample(ProductChannelConfigExample example);

    ProductChannelConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductChannelConfig record, @Param("example") ProductChannelConfigExample example);

    int updateByExample(@Param("record") ProductChannelConfig record, @Param("example") ProductChannelConfigExample example);

    int updateByPrimaryKeySelective(ProductChannelConfig record);

    int updateByPrimaryKey(ProductChannelConfig record);
}