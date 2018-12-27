package com.github.surpassm.aliapi.pay.f2f;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author mc
 * Create date 2018/12/25 10:56
 * Version 1.0
 * Description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({AliPayF2fConfiguration.class})
public @interface EnableAliPayF2fDoc {
}
