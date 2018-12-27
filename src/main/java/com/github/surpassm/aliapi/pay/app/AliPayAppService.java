package com.github.surpassm.aliapi.pay.app;

import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.surpassm.aliapi.entity.AliPayAppModel;

/**
 * @author mc
 * version 1.0
 * date 2018/12/19 11:03
 * description 蚂蚁金服APP支付接口
 */
public interface AliPayAppService {
	/**
	 * APP支付查询接口
	 * @param aliPayAppModel APP支付查询
	 * @return AlipayTradeQueryResponse
	 * @throws JsonProcessingException JSON异常
	 */
	AlipayTradeQueryResponse alipayAppTradeQuery(AliPayAppModel aliPayAppModel) throws JsonProcessingException;

	/**
	 * APP交易退款接口
	 * @param aliPayAppModel 交易退款接口
	 * @return AlipayTradeRefundResponse
	 * @throws JsonProcessingException JSON异常
	 */
	AlipayTradeRefundResponse alipayAppTradeRefund(AliPayAppModel aliPayAppModel) throws JsonProcessingException;


}
