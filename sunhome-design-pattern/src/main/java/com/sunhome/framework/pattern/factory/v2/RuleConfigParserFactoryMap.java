package com.sunhome.framework.pattern.factory.v2;

import com.sunhome.framework.pattern.factory.v1.JsonRuleConfigParser;
import com.sunhome.framework.pattern.factory.v1.RuleConfigParser;
import com.sunhome.framework.pattern.factory.v1.XmlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午4:39
 * @description:
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, RuleConfigParserFactory> cachedParsers = new HashMap<>();

    static {

        cachedParsers.put("json", new JsonRuleConfigParserFactory());
        cachedParsers.put("xml", new XmlRuleConfigParserFactory());
    }

    public static RuleConfigParserFactory getParserFactory(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            throw new IllegalArgumentException("configFormat param is null");
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }

}
