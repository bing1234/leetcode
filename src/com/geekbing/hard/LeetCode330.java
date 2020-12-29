package com.geekbing.hard;

/**
 * todo
 */
public class LeetCode330 {
    public int minPatches(int[] nums, int n) {
        int index = 0, ans = 0;
        long x = 1;
        while (x <= n) {
            if (index < nums.length && nums[index] <= x) {
                x += nums[index++];
            } else {
                ans++;
                x *= 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode330 leetCode330 = new LeetCode330();
        System.out.println(leetCode330.minPatches(new int[]{1, 3}, 6));
        System.out.println(leetCode330.minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(leetCode330.minPatches(new int[]{1, 2, 2}, 5));
    }
}
