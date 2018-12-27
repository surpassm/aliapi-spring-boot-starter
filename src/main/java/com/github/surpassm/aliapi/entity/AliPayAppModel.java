package com.github.surpassm.aliapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * Create date 2018/12/27 11:20
 * Version 1.0
 * Description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliPayAppModel {
	/**
	 * 支付时传入的商户订单号，与tradeNo必填一个
	 */
	private String outTradeNo;
	/**
	 * 支付时返回的支付宝交易号，与ooutTradeNo必填一个
	 */
	private String tradeNo;
	/**
	 *本次退款请求流水号，部分退款时必传
	 */
	private String outRequestNo;
	/**
	 *本次退款金额
	 */
	private String refundAmount;
}
