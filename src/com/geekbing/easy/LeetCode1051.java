package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode1051 {
    public int heightChecker(int[] heights) {
        int[] copyArr = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(copyArr);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copyArr[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1051 leetCode1051 = new LeetCode1051();
        System.out.println(leetCode1051.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(leetCode1051.heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(leetCode1051.heightChecker(new int[]{1, 2, 3, 4, 5}));
    }
}
