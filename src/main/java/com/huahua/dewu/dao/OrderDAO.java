package com.huahua.dewu.dao;

import com.huahua.dewu.dataobject.OrderDO;
import com.huahua.dewu.param.QueryOrderParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * dao模块
 * 将SQL方法转化成对应的Java方法
 */

@Mapper
public interface OrderDAO {
    int insert(OrderDO order);

    int selectCounts(QueryOrderParam param);

    List<OrderDO> pageQuery(QueryOrderParam param);

    OrderDO selectByOrderNumber(String orderNumber);

    int update(OrderDO orderDO);
}
