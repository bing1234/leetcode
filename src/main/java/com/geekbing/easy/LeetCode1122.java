package com.geekbing.easy;

import java.util.*;

public class LeetCode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }

        int[] ans = new int[arr1.length];
        // 不在arr2中的元素，先排在末尾
        int lastIdx = ans.length - 1;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            if (!set.contains(num)) {
                ans[lastIdx--] = num;
            } else {
                countMap.merge(num, 1, Integer::sum);
            }
        }

        int idx = 0;
        for (int num : arr2) {
            for (int i = 0; i < countMap.get(num); i++) {
                ans[idx++] = num;
            }
        }
        Arrays.sort(ans, idx, ans.length);
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1122 leetCode1122 = new LeetCode1122();
        System.out.println(Arrays.toString(leetCode1122.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
