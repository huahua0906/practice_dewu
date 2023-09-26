package com.youkeda.dewu.dao;

import com.youkeda.dewu.dataobject.ProductDO;
import com.youkeda.dewu.param.BasePageParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * dao模块
 * 将SQL方法转化成对应的Java方法
 */

@Mapper
public interface ProductDAO {
    int deleteByPrimaryKey(String id);

    int insert(ProductDO record);

    ProductDO selectByPrimaryKey(String id);

    List<ProductDO> selectAll();

    int updateByPrimaryKey(ProductDO record);

    int selectAllCounts();

    List<ProductDO> pageQuery(BasePageParam param);

}