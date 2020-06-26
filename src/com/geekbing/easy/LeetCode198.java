package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] moneys = new int[nums.length];
        moneys[0] = nums[0];
        moneys[1] = Math.max(nums[0], nums[1]);

        int max = Math.max(moneys[0], moneys[1]);
        for (int i = 2; i < nums.length; i++) {
            moneys[i] = Math.max(moneys[i - 2] + nums[i], moneys[i - 1]);
            if (moneys[i] > max) {
                max = moneys[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode198 leetCode198 = new LeetCode198();
        System.out.println(leetCode198.rob(new int[]{1, 2, 3, 1}));
        System.out.println(leetCode198.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
