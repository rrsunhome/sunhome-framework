package com.sunhome.framework.pattern.chain.v1;

import com.sunhome.framework.util.CommonServiceLoader;

import java.util.List;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午3:35
 */
public class ChainBootstrap {

    public static void main(String[] args) {

//        SensitiveWordChain chain = new DefaultSensitiveWordChain();
//        String world = "乱啊百度";
//        String word = chain.filter(world);
//        System.out.println(word);

        List<SensitiveWordFilter> candidateFilters = CommonServiceLoader.loadProvider(SensitiveWordFilter.class);

        System.out.println(candidateFilters);

    }
}
