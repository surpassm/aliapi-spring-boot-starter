package com.github.surpassm.aliapi.pay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.github.surpassm.aliapi.common.enums.ExcaptionEnums;
import com.github.surpassm.aliapi.common.exception.CustomExcaption;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author mc
 * version 1.0
 * date 2018/12/19 10:38
 * description 无锁编程
 */
@Configuration
public class SingleThreadAliPayClientHolderConfig {

	private AliPayProperties aliPayProperties;

	@Bean
	@ConditionalOnMissingBean
	public AliPayProperties aliPayProperties(){
		AliPayProperties aliPayProperties = new AliPayProperties();
		this.aliPayProperties =aliPayProperties;
		return aliPayProperties;
	}

	/**
	 * 封装成线程局部变量
	 */
	private static ThreadLocal<AlipayClient> threadLocal = new ThreadLocal<>();

	/**
	 * 饥饿模式
	 * @return AlipayClient
	 */
	private  AlipayClient getAliPayClientHolder(AliPayProperties payProperties){

		AlipayClient alipayClient = threadLocal.get();

		if (alipayClient == null){
			try {
				alipayClient = new DefaultAlipayClient(
						payProperties.getUrl(),
						payProperties.getAppId(),
						payProperties.getAppPrivateKey(),
						payProperties.getFormat(),
						payProperties.getCharset(),
						payProperties.getAliPayPublicKey(),
						payProperties.getSignType());
			}catch (NullPointerException e){
				throw new CustomExcaption(String.format(ExcaptionEnums.PARAMETERS_NOTNULL.getValue()+"详情如下：%s",e.getMessage()));

			}
			threadLocal.set(alipayClient);
		}
		return alipayClient;
	}

	@Bean
	@ConditionalOnMissingBean(name = "aliPayClient")
	public AlipayClient getAliPayClient(){
		return getAliPayClientHolder(aliPayProperties);
	}
}
