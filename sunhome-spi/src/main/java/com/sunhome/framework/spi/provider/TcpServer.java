package com.sunhome.framework.spi.provider;

import com.sunhome.framework.spi.annotation.Condition;
import com.sunhome.framework.spi.api.Server;

@Condition(key = "server", value = "tcpServer")
public class TcpServer implements Server {

    @Override
    public void start() {
        System.out.println("tcp start ....");
    }

    @Override
    public void stop() {
        System.out.println("tcp stop ....");

    }
}
