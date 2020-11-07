package com.geekbing.hard;

import java.util.TreeMap;

public class LeetCode327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // 前缀和
//        lower <= sum[j] - sum[i] <= upper
//        sum[j] - upper <= sum[i] <= sum[j] - lower
        // 区间和 - 区间和出现的次数
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        treeMap.put(0L, 1);
        int ans = 0;
        long sum = 0L;
        for (int num : nums) {
            sum += num;
            for (int count : treeMap.subMap(sum - upper, true, sum - lower, true).values()) {
                ans += count;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode327 leetCode327 = new LeetCode327();
        System.out.println(leetCode327.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
