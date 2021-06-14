package com.geekbing.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                count++;
            }
            if (map.containsKey(count - k)) {
                ans += map.get(count - k);
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1248 leetCode1248 = new LeetCode1248();

        System.out.println(leetCode1248.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(leetCode1248.numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(leetCode1248.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
