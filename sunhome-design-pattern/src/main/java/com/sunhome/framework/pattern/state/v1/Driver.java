package com.sunhome.framework.pattern.state.v1;

/**
 * @author : wangqijia
 * create at:  2020/4/7  下午5:43
 */
public class Driver {

    private CarState currentState;

    public Driver() {
        this.currentState = CarState.START;
    }

    public void start() {
        if (CarState.START.equals(currentState)) {
            currentState = CarState.RUNNING;
            System.out.println("start ....");
        }
    }

    public void close() {
        if (CarState.RUNNING.equals(currentState)) {
            currentState = CarState.CLOSED;
            System.out.println("close ....");
        }
    }


}
