package com.sunhome.framework.pattern.factory.v2;


import com.sunhome.framework.pattern.factory.v1.RuleConfig;
import com.sunhome.framework.pattern.factory.v1.RuleConfigParser;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午4:43
 * @description:
 */
public class RuleConfigSource {


    public RuleConfig load(String ruleConfigFilePath) {

        String ruleConfigFileSuffix = getConfigFileSuffix(ruleConfigFilePath);

        RuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileSuffix);


        RuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);

        return ruleConfig;

    }

    public String getConfigFileSuffix(String ruleConfigFilePath) {
        // 解析文件的后缀类型
        return "json";
    }
}
