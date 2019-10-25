package com.sunhome.framework.thread.base.chapter5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerApiBootstrap {

    public static void main(String[] args) {
        // testSchedule();

        testDelaySchedule();

        // testDelayScheduleAtFixedRate();

    }

    private static void testDelayScheduleAtFixedRate() {
        Timer timer = new Timer();

        DelayTimerTask delayTimerTask = new DelayTimerTask();
        try {
            timer.scheduleAtFixedRate(delayTimerTask, DateUtils.parse("2019-10-22 15:28:00"), 2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void testDelaySchedule() {
        Timer timer = new Timer();

        DelayTimerTask delayTimerTask = new DelayTimerTask();

        try {
            timer.schedule(delayTimerTask, DateUtils.parse("2019-10-22 15:28:00"), 2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private static void testSchedule() {
        // 设置daemon为守护线程
        Timer timer = new Timer(true);
        SystemTimerTask systemTimerTask = new SystemTimerTask();
        try {
            // timer.schedule(systemTimerTask, DateUtils.parse("2019-10-22 15:16:00"));

            timer.schedule(systemTimerTask, DateUtils.parse("2019-10-22 15:19:00"), 2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class DelayTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("begin" + Thread.currentThread().getName() + ":" + DateUtils.format(new Date()));

        // 睡眠三秒，模拟延迟
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end" + Thread.currentThread().getName() + ":" + DateUtils.format(new Date()));
    }
}


class SystemTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("time:" + DateUtils.format(new Date()));
    }
}


class DateUtils {
    // SimpleDateFormat 非线程安全
    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }

    public static Date parse(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.parse(dateStr);
    }


}
