package com.sunhome.framework.thread.core.chapter3;

/**
 * ThreadLocal 跟当前线程绑定，用于存储当前线程副本
 */
public class ThreadLocalBootStrap {


    public static void main(String[] args) {
        // 测试主线程
        // testThreadLocal();
        // 测试多线程
        // testMultiThreadLocal();
        // 测试默认值
        //ThreadLocalUtils.printCurrentValue();
    }

    private static void testMultiThreadLocal() {
        // 测试多线程下内容是否被替换
        new Thread(new Runnable() {
            public void run() {
                ThreadLocalUtils.add(Thread.currentThread().getName());
                ThreadLocalUtils.printCurrentValue();

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                ThreadLocalUtils.add(Thread.currentThread().getName());
                ThreadLocalUtils.printCurrentValue();

            }
        }).start();
    }

    private static void testThreadLocal() {
        ThreadLocalUtils.add("test local");
        ThreadLocalUtils.add("test local v1");

        ThreadLocalUtils.printCurrentValue();
    }

}


class ThreadLocalUtils {
//    private static ThreadLocal threadLocal = new ThreadLocal();

    private static ThreadLocal threadLocal = new ThreadLocalExt();


    public static <T> void add(T t) {
        threadLocal.set(t);
    }


    public static Object get() {
        return threadLocal.get();
    }

    public static void printCurrentValue() {
        System.out.println(get());
    }

}

class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {
        return "hello world";
    }
}



