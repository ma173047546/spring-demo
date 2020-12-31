package com.study.ioc.annotation;

import com.study.ioc.aop.KaneAopBeanPostProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(KaneAopBeanPostProcessor.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Kane {
}
