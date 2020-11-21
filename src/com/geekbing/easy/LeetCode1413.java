package com.geekbing.easy;

public class LeetCode1413 {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return min >= 0 ? 1 : 1 - min;
    }

    public static void main(String[] args) {
        LeetCode1413 leetCode1413 = new LeetCode1413();
        System.out.println(leetCode1413.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(leetCode1413.minStartValue(new int[]{1, 2}));
        System.out.println(leetCode1413.minStartValue(new int[]{1, -2, -3}));
    }
}
