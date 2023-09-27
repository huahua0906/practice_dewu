package com.huahua.dewu.model;

/**
 * model模块
 * 和dataobject中的模型对应，用于返回给前端的模型
 */

public enum PaymentStatus {
    /**
     * 支付中
     */
    PENDING,
    /**
     * 支付成功
     */
    SUCCESS,
    /**
     * 支付失败
     */
    FAILURE,
    /**
     * 退款成功
     */
    REFUND_SUCCESS,
    /**
     * 退款失败
     */
    REFUND_FAILED
}
