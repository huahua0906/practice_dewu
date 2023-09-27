package com.huahua.dewu.service;

import com.huahua.dewu.param.PaymentParam;
import com.huahua.dewu.model.Result;

import java.util.Map;

/**
 * service模块
 * 用于处理业务逻辑，会调用dao层类中的方法
 * 此处的方法全为interface
 */

public interface PayService {
    /**
     * 支付订单
     *
     * @param paymentParam 支付所需参数
     * @return Result
     */
    Result payOrder(PaymentParam paymentParam);

    /**
     * 支付宝回调接口
     *
     * @param mapParam 支付宝参数
     * @return Result
     */
    Result alipayCallBack(Map<String, String> mapParam);
}
