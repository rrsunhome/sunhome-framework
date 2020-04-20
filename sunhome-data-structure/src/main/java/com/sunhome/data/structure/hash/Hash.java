package com.sunhome.data.structure.hash;

import java.util.Objects;

/**
 * @author : wangqijia
 * create at:  2020/4/19  下午6:11
 */
public class Hash {

    public static void main(String[] args) {
        int hash = Objects.hash(1, 2);
        System.out.println(hash);
    }

}
