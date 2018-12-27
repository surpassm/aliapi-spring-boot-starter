package com.github.surpassm.aliapi.pay.app;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.surpassm.aliapi.common.constants.AliPayConstants;
import com.github.surpassm.aliapi.common.enums.ExcaptionEnums;
import com.github.surpassm.aliapi.common.exception.CustomExcaption;
import com.github.surpassm.aliapi.entity.AliPayAppModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mc
 * Create date 2018/12/27 11:30
 * Version 1.0
 * Description
 */
@Slf4j
@Service
public class AliPayAppServiceImpl implements AliPayAppService {
	@Resource
	private ObjectMapper objectMapper;
	@Resource
	private AlipayClient alipayClient;

	@Override
	public AlipayTradeQueryResponse alipayAppTradeQuery(AliPayAppModel aliPayAppModel) throws JsonProcessingException {
		//支付时传入的商户订单号，非空
		if (aliPayAppModel.getOutTradeNo() == null || !"".equals(aliPayAppModel.getOutTradeNo())){
			log.info("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//支付时返回的支付宝交易号，非空
		if (aliPayAppModel.getTradeNo() == null || !"".equals(aliPayAppModel.getTradeNo())){
			log.info("tradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("tradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		if (aliPayAppModel.getOutRequestNo() != null){
			log.info("outRequestNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("outRequestNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		if (aliPayAppModel.getRefundAmount() != null){
			log.info("refundAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("refundAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		request.setBizContent(objectMapper.writeValueAsString(aliPayAppModel));
		//通过aliPayClient调用API，获得对应的response类
		AlipayTradeQueryResponse response;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			log.info(e.getErrMsg());
			throw new CustomExcaption(e.getMessage());
		}
		return response;
	}

	@Override
	public AlipayTradeRefundResponse alipayAppTradeRefund(AliPayAppModel aliPayAppModel) throws JsonProcessingException {
		//支付时传入的商户订单号，非空
		if (aliPayAppModel.getOutTradeNo() == null || !"".equals(aliPayAppModel.getOutTradeNo())){
			log.info("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//支付时返回的支付宝交易号，非空
		if (aliPayAppModel.getTradeNo() == null || !"".equals(aliPayAppModel.getTradeNo())){
			log.info("tradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("tradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		if (aliPayAppModel.getOutRequestNo() == null || !"".equals(aliPayAppModel.getOutRequestNo())){
			log.info("outRequestNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("outRequestNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		if (aliPayAppModel.getRefundAmount() == null || !"".equals(aliPayAppModel.getRefundAmount())){
			log.info("refundAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("refundAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		try {
			if(Integer.valueOf(aliPayAppModel.getRefundAmount()) < AliPayConstants.totalAmountMin ){
				log.info("refundAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
				throw new CustomExcaption("refundAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			}

		}catch (Exception e){
			throw new CustomExcaption(ExcaptionEnums.TYPE_ERROR.getValue());
		}

		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		request.setBizContent(objectMapper.writeValueAsString(aliPayAppModel));
		//通过aliPayClient调用API，获得对应的response类
		AlipayTradeRefundResponse response;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			log.info(e.getErrMsg());
			throw new CustomExcaption(e.getMessage());
		}
		return response;
	}
}
