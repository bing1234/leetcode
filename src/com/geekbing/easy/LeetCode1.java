package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        // 存放数字，该数字的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        int[] result = leetCode1.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
