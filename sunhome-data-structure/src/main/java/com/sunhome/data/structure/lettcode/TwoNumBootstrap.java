package com.sunhome.data.structure.lettcode;

/**
 * 找出两数相加为指定的target
 *
 * @author : wangqijia
 * create at:  2020/4/16  下午6:11
 */
public class TwoNumBootstrap {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 6, 1};
        int target = 50;
        int[] twoNum = twoNum(nums, target);
        System.out.println(twoNum[0] + ":" + twoNum[1]);

        System.out.println();


    }

    private static int[] twoNum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("没有两数相加为指定的target");
    }


}
