package com.sunhome.framework.pattern.factory.v2;

import com.sunhome.framework.pattern.factory.v1.RuleConfig;
import com.sunhome.framework.pattern.factory.v2.RuleConfigSource;

/**
 * 简单工厂模式
 *
 * @author : qijia.wang
 * create at:  2020/3/29  下午4:47
 * @description:
 */
public class RuleConfigBootstrap {

    public static void main(String[] args) {

        RuleConfigSource ruleConfigSource = new RuleConfigSource() {

            // 重写扩展名便于测试
            @Override
            public String getConfigFileSuffix(String ruleConfigFilePath) {

                return "xml";
            }
        };

        RuleConfig ruleConfig = ruleConfigSource.load("");

    }
}
