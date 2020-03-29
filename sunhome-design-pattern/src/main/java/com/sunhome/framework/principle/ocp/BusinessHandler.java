package com.sunhome.framework.principle.ocp;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午8:52
 * @description:
 */
public interface BusinessHandler extends Matchable {

    String getDetailUrl();

    String getAuditUrl();


}
