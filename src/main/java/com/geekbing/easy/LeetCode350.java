package com.geekbing.easy;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count > 0) {
                ans.add(num);
                map.put(num, count - 1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        LeetCode350 leetCode350 = new LeetCode350();
        System.out.println(Arrays.toString(leetCode350.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(leetCode350.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
