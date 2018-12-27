# 简介
- 蚂蚁金服API接口自动装配使用封装包含：
    - 支付能力
        - 当面付 //@EnableAliPayF2fDoc 
        - App支付
        - 手机网站支付
        - 电脑网站支付
        - 花呗分期
        - 收单资金结算到银行账户的到账消息
        - 刷脸付
- 源码地址：
  - GitHub:https://github.com/surpassm/aliapi-spring-boot-starter
### 版本基础
- spring-boot-starter 版本为：2.1.1.RELEASE
- 基于alibaba封装的SDK做自动装配，减少阅读官方使用说明，只需要配置关键参数，开发人员只着重具体项目业务逻辑即可
```
<!-- 支付相关 -->
<dependency>
    <groupId>com.alipay.sdk</groupId>
    <artifactId>alipay-sdk-java</artifactId>
    <version>3.4.49.ALL</version>
</dependency>
```
## [Release暂时无发布]()

## 如何使用
在该项目的帮助下，你可以快速的接入蚂蚁金服相关API
- 第一步：加入依赖
```
<dependency>
    <groupId>com.github.surpassm</groupId>
    <artifactId>aliapi-spring-boot-starter</artifactId>
    <version>0.0.1.RELEASE</version>
</dependency>
```
- 第二步：在应用主类中增加@EnableAli+接口能力+类型+Doc注解。具体注解含义请参考简介

```$xslt
@EnableAliPayF2fDoc  //这个注解是启动:支付能力->当面付
@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
}
```
### 每个API使用方式
#### 一、支付能力

#### 1. 当面付

- 第一步：加入依赖
```
<dependency>
    <groupId>com.github.surpassm</groupId>
    <artifactId>aliapi-spring-boot-starter</artifactId>
    <version>0.0.1.RELEASE</version>
</dependency>
```
- 第二步：在应用主类中增加@EnableAliPayF2fDoc注解。

```$xslt
@EnableAliPayF2fDoc  //这个注解是启动:支付能力->当面付
@SpringBootApplication
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

}
```
- 第三步：在application.yml中配置
```$xslt
ali:
  pay:
    f2f:
      #启动当面付功能 必填
      f2fEnable: true
    #请求和签名使用的字符编码格式，支持GBK和UTF-8 默认UTF-8 可以不填
    charset: UTF-8
    #商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2 默认RSA2 可以不填
    signType: RSA2
    #参数返回格式，只支持json 可以不填
    format: json
    #支付宝网关 可以不填
    url: https://openapi.alipay.com/gateway.do
    #应用标识 必填
    appId:
    #应用私钥 必填
    appPrivateKey:
    #支付宝公钥，由支付宝生成 必填
    aliPayPublicKey:
```
- 第四步：调用AliPayF2fService 接口 
    - AlipayTradePayF2fModel 属性说明请参见类-> com.github.surpassm.aliapi.entity.AlipayTradePayF2fModel;
    - 下面是Demo:
```
@Resource
privet AliPayF2fService aliPayF2fService;
AlipayTradePayResponse respone = aliPayF2fService.aliPayF2fBarCode(AlipayTradePayF2fModel.builder()
                                                                            .authCode() //用户付款码
                                                                            .outTradeNo()//商户订单号，需要保证不重复
                                                                            .storeId()//商户门店编号
                                                                            .totalAmount()//订单总金额，单位为元
                                                                            .timeoutExpress();//交易超时时间 单位秒);

```



