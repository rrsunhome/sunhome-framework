package com.sunhome.framework.thread.core.chapter2;

/**
 * 字符串常量的比较
 */
public class StringCompare {

    public static void main(String[] args) {

        String c = new String("ab");
        String d = new String("ab");

        System.out.println(c == d);
        System.out.println(c.intern() == d.intern());
        System.out.println(c.intern()+"-"+d.intern());


    }
}
