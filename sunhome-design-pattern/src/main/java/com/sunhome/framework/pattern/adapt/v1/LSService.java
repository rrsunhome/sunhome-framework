package com.sunhome.framework.pattern.adapt.v1;


/**
 * 假设第三方提供的（名称不够规范，想通过适配成本项目中规范的）
 *
 * @author : qijia.wang
 * create at:  2020/3/29  下午8:05
 * @description:
 */
public class LSService {

    void query(String LsNo, String ksDate, String jsDate) {
        System.out.printf("statementNo:%s,ksDate:%s-jsDate:%s \n", LsNo, ksDate, jsDate);
    }
}
