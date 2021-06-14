package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        return false;
    }

    public static void main(String[] args) {
        LeetCode523 leetCode523 = new LeetCode523();

        System.out.println(leetCode523.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(leetCode523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(leetCode523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }
}
