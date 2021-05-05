package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1437 {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }
        int lastIdx = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i - lastIdx <= k) {
                return false;
            }
            lastIdx = i;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1437 leetCode1437 = new LeetCode1437();
        System.out.println(leetCode1437.kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(leetCode1437.kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(leetCode1437.kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(leetCode1437.kLengthApart(new int[]{0, 1, 0, 1}, 1));
    }
}
