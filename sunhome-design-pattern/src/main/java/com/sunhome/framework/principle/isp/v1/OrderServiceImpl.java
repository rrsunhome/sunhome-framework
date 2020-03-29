package com.sunhome.framework.principle.isp.v1;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午9:31
 * @description:
 */
public class OrderServiceImpl implements OrderService, OrderPaymentService {


    @Override
    public boolean payment(String orderNo) {
        System.out.println("pay order");
        return false;
    }

    @Override
    public String queryOrder(String orderNo) {
        System.out.println("query order");
        return null;
    }

    @Override
    public void deleteOrder(String orderNo) {
        System.out.println("delete order");

    }
}
