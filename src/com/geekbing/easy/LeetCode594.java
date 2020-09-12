package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        int max = 0;
        for (int key : map.keySet()) {
            if (map.get(key + 1) == null) {
                continue;
            }
            int cur = map.get(key) + map.get(key + 1);
            if (max < cur) {
                max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode594 leetCode594 = new LeetCode594();
        System.out.println(leetCode594.findLHS(new int[]{1, 1, 1, 1}));
        System.out.println(leetCode594.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}
