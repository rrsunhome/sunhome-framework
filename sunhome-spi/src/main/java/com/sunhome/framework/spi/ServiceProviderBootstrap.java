package com.sunhome.framework.spi;

import com.sunhome.framework.spi.annotation.Condition;
import com.sunhome.framework.spi.api.Server;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 模拟spi 自动装配
 */
public class ServiceProviderBootstrap {

    static {
        System.setProperty("server", "httpServer");
    }

    public static void main(String[] args) {

        Server server = getServiceProvider(Server.class);

        server.start();
    }


    private static Server getServiceProvider(Class<Server> serverClass) {
        ServiceLoader<Server> servers = ServiceLoader.load(Server.class);
        Iterator<Server> iterator = servers.iterator();

        String envValue = System.getProperty("server");

        while (iterator.hasNext()) {
            Server server = iterator.next();
            Condition annotation = server.getClass().getAnnotation(Condition.class);
            if (annotation != null && envValue.equals(annotation.value())) {
                return server;
            }
        }
        throw new NullPointerException("未找到执行服务");
    }
}
