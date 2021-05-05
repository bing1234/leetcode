package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // num -> num当前出现的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(nums[i]);
            if (idx != null && i - idx <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode219 leetCode219 = new LeetCode219();
        System.out.println(leetCode219.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(leetCode219.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(leetCode219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
