package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode268 {
    public int missingNumber(int[] nums) {
        long sum = (nums.length + 1) * nums.length / 2;
        for (int num : nums){
            sum = sum - num;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        LeetCode268 leetCode268 = new LeetCode268();
        System.out.println(leetCode268.missingNumber(new int[]{3, 0, 1}));
        System.out.println(leetCode268.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
