package com.huahua.dewu.api;

import com.huahua.dewu.model.PaymentRecord;
import com.huahua.dewu.model.PaymentStatus;
import com.huahua.dewu.model.Result;
import com.huahua.dewu.param.PaymentParam;
import com.huahua.dewu.service.PayService;
import com.huahua.dewu.service.PaymentRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * api模块
 * 返回给前端渲染页面的接口，会调用service中的接口
 */

@Controller
@RequestMapping(path = "/api/alipay")
public class PaymentApi {
    private static final Logger logger = LoggerFactory.getLogger(PaymentApi.class);

    @Autowired
    private PayService payService;

    @Autowired
    private PaymentRecordService paymentRecordService;

    /**
     * 支付接口
     *
     */
    @PostMapping(path = "/pay")
    @ResponseBody
    public Result payOrder(@RequestBody PaymentParam paymentParam) {
        Result result = new Result();
        result.setSuccess(true);
        if (StringUtils.isEmpty(paymentParam.getUserId())) {
            result.setSuccess(false);
            result.setMessage("userId is null");
            return result;
        }
        if (paymentParam.getPayAmount() <= 0) {
            result.setMessage("支付金额不能小于0");
            return result;
        }
        PaymentRecord paymentRecord = initPaymentRecord(paymentParam);
        PaymentRecord saveResult = paymentRecordService.save(paymentRecord);
        if (saveResult == null) {
            logger.error("支付流水记录插入失败！");
        }
        return payService.payOrder(paymentParam);
    }

    /**
     * 组装支付记录
     *
     * @param paymentParam paymentParam
     * @return PaymentRecord
     */
    private PaymentRecord initPaymentRecord(PaymentParam paymentParam) {
        PaymentRecord paymentRecord = new PaymentRecord();
        paymentRecord.setPayType(paymentParam.getPayType());
        paymentRecord.setPayStatus(PaymentStatus.PENDING);
        paymentRecord.setUserId(paymentParam.getUserId());
        paymentRecord.setOrderNumber(paymentParam.getOrderNumber());
        paymentRecord.setAmount(paymentParam.getPayAmount());
        return paymentRecord;
    }
}
