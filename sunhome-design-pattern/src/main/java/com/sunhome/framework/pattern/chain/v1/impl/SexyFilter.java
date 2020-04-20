package com.sunhome.framework.pattern.chain.v1.impl;

import com.sunhome.framework.pattern.chain.v1.SensitiveWordChain;
import com.sunhome.framework.pattern.chain.v1.SensitiveWordFilter;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午3:31
 */
public class SexyFilter implements SensitiveWordFilter {

    @Override
    public String doFilter(String word, SensitiveWordChain chain) {
        String replaceWorld = word.replace("乱", "");

        return chain.filter(replaceWorld);
    }
}
