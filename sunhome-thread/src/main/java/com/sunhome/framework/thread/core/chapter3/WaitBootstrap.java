package com.sunhome.framework.thread.core.chapter3;


import lombok.AllArgsConstructor;


/**
 * wait/notify 简单交互
 */
public class WaitBootstrap {

    public static void main(String[] args) {
        Service service = new Service();

        WaitThread waitThread = new WaitThread(service);

        NotifyThread notifyThread = new NotifyThread(service);

        waitThread.start();
        notifyThread.start();
    }
}



@AllArgsConstructor
class WaitThread extends Thread {

    private Service service;


    @Override
    public void run() {
        synchronized (service) {
            System.out.println("begin wait");
            try {
                service.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end wait");

        }

    }
}

@AllArgsConstructor
class NotifyThread extends Thread {

    private Service service;

    @Override
    public void run() {
        synchronized (service) {
            System.out.println("begin notify");
            service.notifyAll();
            System.out.println("end notify");
        }
    }
}


class Service {


}
