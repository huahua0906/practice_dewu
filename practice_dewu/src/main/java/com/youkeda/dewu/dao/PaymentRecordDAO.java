package com.youkeda.dewu.dao;

import com.youkeda.dewu.dataobject.PaymentRecordDO;
import com.youkeda.dewu.param.PaymentRecordQueryParam;
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