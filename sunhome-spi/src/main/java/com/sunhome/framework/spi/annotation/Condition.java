package com.sunhome.framework.spi.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Condition {

    String key() default "";

    String value() default "";
}
