package com.geekbing.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumMap1 = sumOfTwoArr(A, B);
        Map<Integer, Integer> sumMap2 = sumOfTwoArr(C, D);
        int ans = 0;
        for (int key1 : sumMap1.keySet()) {
            if (sumMap2.containsKey(-key1)) {
                ans += sumMap1.get(key1) * sumMap2.get(-key1);
            }
        }
        return ans;
    }

    private Map<Integer, Integer> sumOfTwoArr(int[] arr1, int[] arr2) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                int sum = num1 + num2;
                ans.merge(sum, 1, Integer::sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode454 leetCode454 = new LeetCode454();
        System.out.println(leetCode454.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
