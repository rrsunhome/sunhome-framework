package com.sunhome.framework.spi.provider;

import com.sunhome.framework.spi.annotation.Condition;
import com.sunhome.framework.spi.api.Server;

@Condition(key = "server", value = "httpServer")
public class HttpServer implements Server {



    @Override
    public void start() {
        System.out.println("http start ....");
    }

    @Override
    public void stop() {
        System.out.println("http stop ....");

    }
}
