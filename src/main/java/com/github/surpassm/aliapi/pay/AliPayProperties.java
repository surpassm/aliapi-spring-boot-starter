package com.github.surpassm.aliapi.pay;

import com.github.surpassm.aliapi.pay.app.AliPayAppProperties;
import com.github.surpassm.aliapi.pay.f2f.AliPayF2fProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mc
 * version 1.0
 * date 2018/12/14 16:36
 * description 支付封装配置入口类
 */
@Data
@ConfigurationProperties(prefix = "ali.pay")
public class AliPayProperties {
	/**
	 * 支付宝网关
	 */
	private String url="https://openapi.alipay.com/gateway.do";
	/**
	 * 应用标识
	 */
	private String appId ="";
	/**
	 * 应用私钥
	 */
	private String appPrivateKey ="";
	/**
	 * 参数返回格式，只支持json
	 */
	private String format ="json";
	/**
	 * 请求和签名使用的字符编码格式，支持GBK和UTF-8
	 */
	private String charset ="UTF-8";
	/**
	 * 支付宝公钥，由支付宝生成
	 */
	private String aliPayPublicKey ="";
	/**
	 * 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	 */
	private String signType ="RSA2";
	/**
	 * 当面付
	 */
	private AliPayF2fProperties f2f;
	/**
	 * APP支付
	 */
	private AliPayAppProperties app;



}
