package com.sunhome.framework.pattern.chain.v1;

import com.sunhome.framework.pattern.chain.v1.impl.AdsFilter;
import com.sunhome.framework.pattern.chain.v1.impl.SexyFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午3:35
 */
public class ChainBootstrap {

    public static void main(String[] args) {
        List<SensitiveWordFilter> filters = new ArrayList<>();
        filters.add(new SexyFilter());

        filters.add(new AdsFilter());

        SensitiveWordChain chain = new DefaultSensitiveWordChain(filters);

        String world = "乱啊百度";

        String word = chain.filter(world);

        System.out.println(word);


    }
}
