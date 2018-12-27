package com.github.surpassm.aliapi.pay.f2f;

import com.alipay.api.response.AlipayTradePayResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.surpassm.aliapi.entity.*;

/**
 * @author mc
 * version 1.0
 * date 2018/12/19 11:03
 * description 蚂蚁金服当面付接口
 */
public interface AliPayF2fService {
	/**
	 * 当面付- 条码支付
	 * @param aliPayF2FModel 条码支付
	 * @return AlipayTradePayResponse
	 * @throws JsonProcessingException JSON异常
	 */
	AlipayTradePayResponse aliPayF2fBarCode(AliPayF2fModel aliPayF2FModel) throws JsonProcessingException;

	/**
	 * 当面付-扫码支付
	 * @param aliPayF2FModel 扫码支付
	 * @return AlipayTradePayResponse
	 * @throws JsonProcessingException JSON异常
	 */
	AlipayTradePayResponse alipayF2fTradePrecreate(AliPayF2fModel aliPayF2FModel) throws JsonProcessingException;
}
