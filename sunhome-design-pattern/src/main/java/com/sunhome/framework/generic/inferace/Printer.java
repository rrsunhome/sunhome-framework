package com.sunhome.framework.generic.inferace;

/**
 * @author : wangqijia
 * create at:  2020/4/7  下午10:56
 */
public interface Printer<T> {

    String print(T t);


    public static class StringPrinter implements Printer<String> {
        @Override
        public String print(String s) {
            return String.valueOf(s);
        }
    }

}
