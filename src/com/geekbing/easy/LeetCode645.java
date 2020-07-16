package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode645 {
    public int[] findErrorNums(int[] nums) {
        int[] bucket = new int[nums.length];
        int sum = 0, repeat = 0;
        for (int num : nums) {
            if (bucket[num - 1] != 0) {
                repeat = num;
            } else {
                bucket[num - 1] = num;
            }
            sum = sum + num;
        }
        return new int[]{repeat, (1 + nums.length) * nums.length / 2 - sum + repeat};
    }

    public static void main(String[] args) {
        LeetCode645 leetCode645 = new LeetCode645();
        System.out.println(Arrays.toString(leetCode645.findErrorNums(new int[]{1, 2, 2, 4})));
    }
}
