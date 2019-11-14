package com.sunhome.framework.desgin.pattern.base.template;

/**
 * @author wangqijia
 * @date 2019/11/14 17:27
 */
public class CarFileDownProcessor extends AbstractFileDown {


    @Override
    protected String cleanBody(String result) {
        // 不处理
        return result;
    }
}
