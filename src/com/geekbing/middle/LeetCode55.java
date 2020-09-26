package com.geekbing.middle;

public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int maxCanReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCanReach >= i) {
                maxCanReach = Math.max(maxCanReach, i + nums[i]);
                if (maxCanReach >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return maxCanReach >= nums.length - 1;
    }

    public static void main(String[] args) {
        LeetCode55 leetCode55 = new LeetCode55();
        System.out.println(leetCode55.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(leetCode55.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
