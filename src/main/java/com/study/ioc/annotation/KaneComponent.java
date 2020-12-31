package com.study.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//此注解标注在类上
@Retention(RetentionPolicy.RUNTIME)
public @interface KaneComponent {//自定义这个注解
    // 根据注解的不同我们可以干不同的事情。。这个可以展开来描述. 当然 还有@Configuartion+@Bean 但是思路是我完全一样，不需要一个个去举例
}
