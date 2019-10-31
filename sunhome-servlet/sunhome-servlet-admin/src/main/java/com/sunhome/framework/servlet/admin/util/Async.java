package com.sunhome.framework.servlet.admin.util;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Async {

    public static CustomThreadPoolMonitor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static CustomThreadPoolMonitor INSTANCE = new CustomThreadPoolMonitor(100, 200, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), "servletPool");
    }
}
