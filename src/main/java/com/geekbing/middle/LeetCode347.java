package com.geekbing.middle;

import java.util.*;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Set<Integer>[] buckets = new HashSet[nums.length + 1];

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.get(num);
            if (count == null) {
                if (buckets[1] == null) {
                    buckets[1] = new HashSet<>();
                }
                buckets[1].add(num);
                countMap.put(num, 1);
            } else {
                if (buckets[count] == null) {
                    buckets[count] = new HashSet<>();
                }
                if (buckets[count + 1] == null) {
                    buckets[count + 1] = new HashSet<>();
                }
                buckets[count].remove(num);
                buckets[count + 1].add(num);
                countMap.put(num, count + 1);
            }
        }
        int[] ans = new int[k];
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (Integer num : buckets[i]) {
                if (k == 0) {
                    return ans;
                }
                ans[ans.length - k] = num;
                k--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode347 leetCode347 = new LeetCode347();
        System.out.println(Arrays.toString(leetCode347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(leetCode347.topKFrequent(new int[]{1}, 1)));
    }
}
