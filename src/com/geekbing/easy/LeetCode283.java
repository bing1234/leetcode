package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                step++;
            } else {
                nums[i - step] = nums[i];
            }
        }
        int i = nums.length - 1;
        while (zeroNum > 0) {
            nums[i--] = 0;
            zeroNum--;
        }
    }

    public static void main(String[] args) {
        LeetCode283 leetCode283 = new LeetCode283();
        int[] case1 = new int[]{0, 1, 0, 3, 12};
        leetCode283.moveZeroes(case1);
        System.out.println(Arrays.toString(case1));
    }
}
