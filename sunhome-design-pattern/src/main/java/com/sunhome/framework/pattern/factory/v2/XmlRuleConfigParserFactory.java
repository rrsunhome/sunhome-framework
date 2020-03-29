package com.sunhome.framework.pattern.factory.v2;

import com.sunhome.framework.pattern.factory.v1.JsonRuleConfigParser;
import com.sunhome.framework.pattern.factory.v1.RuleConfigParser;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午6:46
 * @description:
 */
public class XmlRuleConfigParserFactory implements RuleConfigParserFactory {

    @Override
    public RuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
