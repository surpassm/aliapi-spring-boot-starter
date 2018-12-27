package com.github.surpassm.aliapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * version 1.0
 * date 2018/12/19 11:16
 * description 当面付- 条码支付
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliPayF2fModel {
	/**
	 * 商户订单号，需要保证不重复
	 */
	private String outTradeNo;
	/**
	 * 条码支付固定传入bar_code
	 */
	private String scene="bar_code";
	/**
	 * 用户付款码，25~30开头的长度为16~24位的数字，实际字符串长度以开发者获取的付款码长度为准
	 */
	private String authCode;
	/**
	 * 订单标题
	 */
	private String subject;
	/**
	 * 商户门店编号
	 */
	private String storeId;
	/**
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 */
	private Double totalAmount;
	/**
	 * 交易超时时间 单位秒  2m
	 */
	private String timeoutExpress;
}

