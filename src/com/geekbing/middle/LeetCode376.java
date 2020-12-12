package com.geekbing.middle;

public class LeetCode376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        // up[i] 表示前i个元素中最长上升子序列的长度
        // down[i] 表示前i个元素中最长下降子序列的长度
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                down[i] = down[i - 1];
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
            } else if (nums[i - 1] == nums[i]) {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    public static void main(String[] args) {
        LeetCode376 leetCode376 = new LeetCode376();
        System.out.println(leetCode376.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(leetCode376.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(leetCode376.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
