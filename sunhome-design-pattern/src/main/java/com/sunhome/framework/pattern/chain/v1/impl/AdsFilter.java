package com.sunhome.framework.pattern.chain.v1.impl;

import com.sunhome.framework.pattern.chain.v1.SensitiveWordChain;
import com.sunhome.framework.pattern.chain.v1.SensitiveWordFilter;
import com.sunhome.framework.util.Ordered;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午3:34
 */
public class AdsFilter implements SensitiveWordFilter, Ordered {

    @Override
    public int getOrder() {
        return -23;
    }

    @Override
    public String doFilter(String word, SensitiveWordChain chain) {
        String replaceWorld = word.replace("百度", "");

        return chain.filter(replaceWorld);
    }
}
