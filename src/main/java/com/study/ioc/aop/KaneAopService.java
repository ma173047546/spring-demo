package com.study.ioc.aop;

import org.springframework.stereotype.Component;

@Component
public class KaneAopService implements KaneAop {
	@Override
	public String getKane() {
		return "kane";
	}
}
