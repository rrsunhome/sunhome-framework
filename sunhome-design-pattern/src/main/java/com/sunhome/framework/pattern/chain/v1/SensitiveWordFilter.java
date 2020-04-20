package com.sunhome.framework.pattern.chain.v1;

public interface SensitiveWordFilter {

    String doFilter(String word, SensitiveWordChain sensitiveWordChain);
}
