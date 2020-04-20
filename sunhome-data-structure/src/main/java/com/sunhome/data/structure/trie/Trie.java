package com.sunhome.data.structure.trie;

import org.apache.commons.collections4.trie.PatriciaTrie;

/**
 * @author : wangqijia
 * create at:  2020/4/19  下午8:14
 */
public class Trie {

    public static void main(String[] args) {
        PatriciaTrie<Double> t = new PatriciaTrie<Double>();
        t.put("人人网", 440.0);
        t.put("人人汽车", 440.0);

        System.out.println(t.prefixMap("人人"));
    }
}
