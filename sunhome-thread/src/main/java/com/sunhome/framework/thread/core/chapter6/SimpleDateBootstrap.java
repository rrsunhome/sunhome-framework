package com.sunhome.framework.thread.core.chapter6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SimpleDateBootstrap {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                // 共享变量
                //compareDate();
                // 为每个线程分配一个对象
                //compareThreadLocalDate();
                // 引用LocalDate解决了多线程不安全问题
                compareLocalDate();
            }).start();
        }
    }

    private static void compareLocalDate() {
        LocalDate localDate = LocalDate.parse("2019-10-23", dateTimeFormatter);
        String localDateStr = localDate.format(dateTimeFormatter);
        if (!"2019-10-23".equals(localDateStr)) {
            System.out.println("nq");
        }
    }

    /**
     * 存在多线程访问问题
     * 共享一个对象导致
     */
    private static void compareDate() {
        Date date = null;
        try {
            date = sdf.parse("2019-10-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void compareThreadLocalDate() {

        try {
            dateFormatThreadLocal.get().parse("2019-10-23");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}




