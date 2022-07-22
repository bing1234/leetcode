package com.geekbing.easy;

public class LeetCode453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int times = 0;
        for (int num : nums) {
            times += num - min;
        }
        return times;
    }

    public static void main(String[] args) {
        LeetCode453 leetCode453 = new LeetCode453();
        System.out.println(leetCode453.minMoves(new int[]{1, 2, 3}));
    }
}
