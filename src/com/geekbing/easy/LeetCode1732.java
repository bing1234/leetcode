package com.geekbing.easy;

public class LeetCode1732 {
    public int largestAltitude(int[] gain) {
        int cur = 0, max = 0;
        for (int num : gain) {
            cur = num + cur;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1732 leetCode1732 = new LeetCode1732();
        System.out.println(leetCode1732.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(leetCode1732.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }
}
