package com.github.surpassm.aliapi.pay.f2f;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.surpassm.aliapi.common.constants.AliPayConstants;
import com.github.surpassm.aliapi.common.enums.ExcaptionEnums;
import com.github.surpassm.aliapi.common.exception.CustomExcaption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.surpassm.aliapi.entity.*;

import javax.annotation.Resource;

/**
 * @author mc
 * version 1.0
 * date 2018/12/19 11:21
 * description 当面付- 条码支付 实现类
 */
@Slf4j
@Service
public class AliPayF2fServiceImpl implements AliPayF2fService {
	@Resource
	private AlipayClient alipayClient;

	@Resource
	private ObjectMapper objectMapper;

	/**
	 * 条码支付实现方法
	 * @param aliPayF2FModel 条码支付
	 * @throws JsonProcessingException JSON异常捕获
	 */
	@Override
	public AlipayTradePayResponse aliPayF2fBarCode(AliPayF2fModel aliPayF2FModel) throws JsonProcessingException {
		//钉钉金额非空判断
		if (aliPayF2FModel.getTotalAmount() == null){
			log.info("totalAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("totalAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		Double totalAmount = aliPayF2FModel.getTotalAmount();
		//判断支付金额是否小于支付接口最小值
		if (totalAmount < AliPayConstants.totalAmountMin || AliPayConstants.totalAmountMax < totalAmount){
			log.info("totalAmount"+ExcaptionEnums.ILLEGAL_PARAMETERS.getValue());
			throw new CustomExcaption("totalAmount"+ExcaptionEnums.ILLEGAL_PARAMETERS.getValue());
		}
		//用户付款码非空判断
		if (aliPayF2FModel.getAuthCode() == null || !"".equals(aliPayF2FModel.getAuthCode())){
			log.info("authCode"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("authCode"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//订单号非空判断
		if (aliPayF2FModel.getOutTradeNo() == null || !"".equals(aliPayF2FModel.getOutTradeNo())){
			log.info("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//商户门店编号非空判断
		if (aliPayF2FModel.getStoreId() == null || !"".equals(aliPayF2FModel.getStoreId())){
			log.info("storeId"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("storeId"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//订单标题非空判断
		if (aliPayF2FModel.getSubject() == null || !"".equals(aliPayF2FModel.getSubject())){
			log.info("subject"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("subject"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		request.setBizContent(objectMapper.writeValueAsString(aliPayF2FModel));
		//通过aliPayClient调用API，获得对应的response类
		AlipayTradePayResponse response;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			log.info(e.getErrMsg());
			throw new CustomExcaption(e.getMessage());
		}
		return response;
	}

	@Override
	public AlipayTradePrecreateResponse alipayF2fTradePrecreate(AliPayF2fModel aliPayF2FModel) throws JsonProcessingException {
		//钉钉金额非空判断
		if (aliPayF2FModel.getTotalAmount() == null){
			log.info("totalAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("totalAmount"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		Double totalAmount = aliPayF2FModel.getTotalAmount();
		//判断支付金额是否小于支付接口最小值
		if (totalAmount < AliPayConstants.totalAmountMin || AliPayConstants.totalAmountMax < totalAmount){
			log.info("totalAmount"+ExcaptionEnums.ILLEGAL_PARAMETERS.getValue());
			throw new CustomExcaption("totalAmount"+ExcaptionEnums.ILLEGAL_PARAMETERS.getValue());
		}
		//订单号非空判断
		if (aliPayF2FModel.getOutTradeNo() == null || !"".equals(aliPayF2FModel.getOutTradeNo())){
			log.info("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("outTradeNo"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//商户门店编号非空判断
		if (aliPayF2FModel.getStoreId() == null || !"".equals(aliPayF2FModel.getStoreId())){
			log.info("storeId"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("storeId"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//订单标题非空判断
		if (aliPayF2FModel.getSubject() == null || !"".equals(aliPayF2FModel.getSubject())){
			log.info("subject"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("subject"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		//超时时间非空判断
		if (aliPayF2FModel.getTimeoutExpress() == null || !"".equals(aliPayF2FModel.getTimeoutExpress())){
			log.info("timeoutExpress"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
			throw new CustomExcaption("timeoutExpress"+ExcaptionEnums.PARAMETERS_NOTNULL.getValue());
		}
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.setBizContent(objectMapper.writeValueAsString(aliPayF2FModel));
		//通过aliPayClient调用API，获得对应的response类
		AlipayTradePrecreateResponse response;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			log.info(e.getErrMsg());
			throw new CustomExcaption(e.getMessage());
		}
		return response;
	}
}
