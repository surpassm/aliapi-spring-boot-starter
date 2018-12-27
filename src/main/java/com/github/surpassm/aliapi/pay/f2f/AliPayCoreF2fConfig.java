package com.github.surpassm.aliapi.pay.f2f;

import com.github.surpassm.aliapi.pay.AliPayProperties;
import com.github.surpassm.aliapi.pay.SingleThreadAliPayClientHolderConfig;
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
@ConditionalOnProperty(name = "ali.pay.f2f.enabled", matchIfMissing = true)
@Import({AliPayF2fServiceImpl.class,
		SingleThreadAliPayClientHolderConfig.class,
		AliPayProperties.class
})
public class AliPayCoreF2fConfig {

}
