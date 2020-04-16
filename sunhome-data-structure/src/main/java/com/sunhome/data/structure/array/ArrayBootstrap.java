package com.sunhome.data.structure.array;

import com.sunhome.data.structure.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试数组和容器的耗时
 * 结论：数组的性能比容器的性能强
 *
 * @author : wangqijia
 * create at:  2020/4/13  下午11:07
 */
public class ArrayBootstrap {


    public static void main(String[] args) {

        StopWatch timeWatch = new StopWatch();
        timeWatch.start("addArray");
        int[] array = addArray(1000000);
        timeWatch.stop();

        timeWatch.start("addContainer");
        // 集合中自动装箱和自动拆箱也会影响性能
        List<Integer> integerList = addContainer(1000000);
        timeWatch.stop();

        timeWatch.start("printArray");
        printArray(array);
        timeWatch.stop();

        timeWatch.start("printContainer");
        printContainer(integerList);
        timeWatch.stop();

        System.out.println(timeWatch.prettyPrint());


    }

    private static void printContainer(List<Integer> integerList) {
        for (Integer integer : integerList) {


        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
        }
    }

    private static List<Integer> addContainer(int i) {
        List<Integer> list = new ArrayList<>(i);
        for (int j = 0; j < i; j++) {
            list.add(j);
        }
        return list;
    }

    private static int[] addArray(int i) {
        int[] array = new int[i];
        for (int j = 0; j < i; j++) {
            array[j] = i;
        }
        return array;
    }
}
