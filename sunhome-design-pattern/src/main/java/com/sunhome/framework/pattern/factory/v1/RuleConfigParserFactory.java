package com.sunhome.framework.pattern.factory.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午4:39
 * @description:
 */
public class RuleConfigParserFactory {

    private static final Map<String, RuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());


    }

    public static RuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            throw new IllegalArgumentException("configFormat param is null");
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }

}
