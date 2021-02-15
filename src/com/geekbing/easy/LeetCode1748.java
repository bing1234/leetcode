package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1748 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ans += key;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1748 leetCode1748 = new LeetCode1748();
        System.out.println(leetCode1748.sumOfUnique(new int[]{1, 2, 3, 2}));
        System.out.println(leetCode1748.sumOfUnique(new int[]{1, 1, 1, 1, 1}));
        System.out.println(leetCode1748.sumOfUnique(new int[]{1, 2, 3, 4, 5}));
    }
}
