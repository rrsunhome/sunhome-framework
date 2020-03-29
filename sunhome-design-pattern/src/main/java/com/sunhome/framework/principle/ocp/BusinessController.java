package com.sunhome.framework.principle.ocp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午9:14
 * @description:
 */
public class BusinessController {

    private List<BusinessHandler> businessHandlers;

    public BusinessController() {
        businessHandlers = new ArrayList<>();
        businessHandlers.add(new OrderBusinessHandler());
        businessHandlers.add(new PaymentBusinessHandler());
    }

    /**
     * 如果业务不多，也可以采用if 判断来写，业务复杂的话建议拆分到具体的类里
     *
     * @param businessName
     * @return
     */
    public String getDetailUrl(String businessName) {
        for (BusinessHandler businessHandler : businessHandlers) {
            if (businessHandler.matched(businessName)) {
                return businessHandler.getDetailUrl();
            }

        }
        return null;
    }

    public String getAuditUrl(String businessName) {
        for (BusinessHandler businessHandler : businessHandlers) {
            if (businessHandler.matched(businessName)) {
                return businessHandler.getAuditUrl();
            }
        }
        return null;
    }


}
