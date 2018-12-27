package com.github.surpassm.aliapi.pay.app;

import com.github.surpassm.aliapi.pay.f2f.AliPayF2fConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author mc
 * Create date 2018/12/25 10:56
 * Version 1.0
 * Description APP支付启动注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({AliPayAppConfiguration.class})
public @interface EnableAliPayAppDoc {
}
