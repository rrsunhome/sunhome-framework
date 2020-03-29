package com.sunhome.framework.pattern.factory.v3;

import com.sunhome.framework.pattern.factory.v1.RuleConfigParser;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午7:08
 * @description:
 */
public interface ConfigParserFactory {

    RuleConfigParser createRuleParser();

    SystemConfigParser createSystemParser();
}
