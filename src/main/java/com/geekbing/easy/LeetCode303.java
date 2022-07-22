package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode303 {
    private final Map<Integer, Integer> map = new HashMap<>();

    public LeetCode303(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);
        }
    }

    public int sumRange(int i, int j) {
        if (i - 1 < 0) {
            return map.get(j);
        }
        return map.get(j) - map.get(i - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        LeetCode303 leetCode303 = new LeetCode303(nums);
        System.out.println(leetCode303.sumRange(0, 2));
        System.out.println(leetCode303.sumRange(2, 5));
        System.out.println(leetCode303.sumRange(0, 5));
    }
}
