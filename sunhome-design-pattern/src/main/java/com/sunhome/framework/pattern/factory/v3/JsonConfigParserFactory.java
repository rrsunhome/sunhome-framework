package com.sunhome.framework.pattern.factory.v3;

import com.sunhome.framework.pattern.factory.v1.JsonRuleConfigParser;
import com.sunhome.framework.pattern.factory.v1.RuleConfigParser;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午7:09
 * @description:
 */
public class JsonConfigParserFactory implements ConfigParserFactory {

    @Override
    public RuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }


    @Override
    public SystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}

