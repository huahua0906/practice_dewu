package com.huahua.dewu.dao;

import com.huahua.dewu.dataobject.PaymentRecordDO;
import com.huahua.dewu.param.PaymentRecordQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * dao模块
 * 将SQL方法转化成对应的Java方法
 */

@Mapper
public interface PaymentRecordDAO {

    int insert(PaymentRecordDO record);

    List<PaymentRecordDO> select(PaymentRecordQueryParam paymentRecordQueryParam);

    int update(PaymentRecordDO record);
}