package com.sunhome.framework.principle.isp.v1;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午9:33
 * @description:
 */
public class OrderBootstrap {

    public static void main(String[] args) {
        // 提供 API，应为付款业务比较核心，只提供给指定模块使用，所以分离出一个接口
        OrderService orderService = new OrderServiceImpl();
        orderService.deleteOrder("");
        orderService.queryOrder("");

        OrderPaymentService orderPaymentService = new OrderServiceImpl();
        orderPaymentService.payment("");

    }
}
