package com.sunhome.framework.pattern.template.v1;

import com.alibaba.fastjson.JSONObject;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午5:28
 * @description:
 */
public class JsonMessageFormatter implements MessageFormatter {

    @Override
    public String format(String message, Level level) {
        JSONObject json = new JSONObject();
        json.put("message", message);
        json.put("level", level.name());
        return json.toJSONString();
    }
}
