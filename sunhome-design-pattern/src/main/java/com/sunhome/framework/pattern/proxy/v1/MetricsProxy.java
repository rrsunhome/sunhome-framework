package com.sunhome.framework.pattern.proxy.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午7:35
 * @description:
 */
public class MetricsProxy {


    public Object createProxy(Object proxyObject) {

        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();

        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, new DynamicProxyHandler(proxyObject));
    }

    private static class DynamicProxyHandler implements InvocationHandler {

        private Object proxyObject;

        public DynamicProxyHandler(Object proxyObject) {
            this.proxyObject = proxyObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();

            Object result = method.invoke(proxyObject, args);

            long end = System.currentTimeMillis();

            System.out.printf("耗时: %d ms\n", end - start);
            return result;
        }
    }
}
