package com.sunhome.framework.principle.ocp;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午9:06
 * @description:
 */
public class PaymentBusinessHandler implements BusinessHandler {

    private static final String MATCH_NAME = "payment";

    @Override
    public String getDetailUrl() {
        return "/payment/detail";
    }

    @Override
    public String getAuditUrl() {
        return "/payment/audit/detail";
    }

    @Override
    public boolean matched(String matchName) {
        return MATCH_NAME.equals(matchName);
    }
}
