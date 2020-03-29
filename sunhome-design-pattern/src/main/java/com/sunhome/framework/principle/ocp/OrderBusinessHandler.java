package com.sunhome.framework.principle.ocp;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午9:06
 * @description:
 */
public class OrderBusinessHandler implements BusinessHandler {

    private static final String MATCH_NAME = "order";

    @Override
    public String getDetailUrl() {
        return "/order/detail";
    }

    @Override
    public String getAuditUrl() {
        return "/order/audit/detail";
    }

    @Override
    public boolean matched(String matchName) {
        return MATCH_NAME.equals(matchName);
    }
}
