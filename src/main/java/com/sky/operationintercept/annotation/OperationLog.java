package com.sky.operationintercept.annotation;

import java.lang.annotation.*;

/**
 * Created by sk on 2022/4/28
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    String value() default "";
}
