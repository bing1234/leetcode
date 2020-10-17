package com.geekbing.easy;

/**
 * 665. 非递减数列
 * https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * @author bing
 */
public class LeetCode665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }
        int changeCount = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            changeCount++;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                changeCount++;
                if (changeCount > 1) {
                    return false;
                }
                if (nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode665 leetCode665 = new LeetCode665();
        System.out.println(leetCode665.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(leetCode665.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(leetCode665.checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(leetCode665.checkPossibility(new int[]{2, 3, 3, 2, 2}));
    }
}
