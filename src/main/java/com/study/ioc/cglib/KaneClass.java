package com.study.ioc.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class KaneClass {
    public void test(){
        System.out.println("kane");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(KaneClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                Object result = methodProxy.invokeSuper(o, objects);
                return result;
            }
        });
        KaneClass kaneClass = (KaneClass) enhancer.create();
        kaneClass.test();
        kaneClass.hashCode();
        kaneClass.toString();
        kaneClass.getClass();
    }
}
