package com.sunhome.framework.principle.ocp;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午9:18
 * @description:
 */
public class OCPBootstrap {

    public static void main(String[] args) {

        BusinessController businessController = new BusinessController();


        String payment = businessController.getAuditUrl("payment");

        System.out.println(payment);
    }
}
