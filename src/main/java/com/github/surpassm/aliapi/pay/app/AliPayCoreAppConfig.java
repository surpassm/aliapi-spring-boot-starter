package com.github.surpassm.aliapi.pay.app;

import com.github.surpassm.aliapi.pay.AliPayProperties;
import com.github.surpassm.aliapi.pay.SingleThreadAliPayClientHolderConfig;
import com.github.surpassm.aliapi.pay.f2f.AliPayF2fServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author mc
 * version 1.0
 * date 2018/12/14 16:35
 * description 读取器
 */
@Configuration
@ConditionalOnProperty(name = "ali.pay.app.appEnable", matchIfMissing = true)
@Import({AliPayAppServiceImpl.class,
		SingleThreadAliPayClientHolderConfig.class,
		AliPayProperties.class
})
public class AliPayCoreAppConfig {

}
