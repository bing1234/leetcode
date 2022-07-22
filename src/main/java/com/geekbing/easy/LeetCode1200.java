package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < minDiff) {
                minDiff = arr[i] - arr[i - 1];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1200 leetCode1200 = new LeetCode1200();
        System.out.println(leetCode1200.minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(leetCode1200.minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(leetCode1200.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }
}
