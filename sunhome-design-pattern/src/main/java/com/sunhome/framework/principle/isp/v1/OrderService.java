package com.sunhome.framework.principle.isp.v1;

public interface OrderService {

    String queryOrder(String orderNo);

    void deleteOrder(String orderNo);

}
