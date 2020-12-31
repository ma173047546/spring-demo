package com.study.ioc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class KaneInvocationHandler implements InvocationHandler {

	Object target;

	public KaneInvocationHandler(Object target) {
		this.target = target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//开始执行
		System.out.println("before");

		return method.invoke(target,args);
	}
}
