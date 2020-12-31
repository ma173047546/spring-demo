package com.study.ioc.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class KaneAopBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Object obj = null;
           if(beanName.equals("kaneAopService")) {
			   Class<?>[] interfaces = bean.getClass().getInterfaces();//通过反射获取所有接口
			   obj = Proxy.newProxyInstance(KaneAopBeanPostProcessor.class.getClassLoader(), interfaces, new KaneInvocationHandler(bean));
		   }
		return obj;
	}
}
