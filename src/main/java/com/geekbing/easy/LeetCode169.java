package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        // 剩余的数字，剩余的数量
        int leftNum = nums[0], leftCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (leftCount == 0) {
                leftNum = nums[i];
                leftCount++;
            } else {
                if (nums[i] == leftNum) {
                    leftCount++;
                } else {
                    leftCount--;
                }
            }
        }
        return leftNum;
    }

    public static void main(String[] args) {
        LeetCode169 leetCode169 = new LeetCode169();
        System.out.println(leetCode169.majorityElement(new int[]{3, 2, 3}));
        System.out.println(leetCode169.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
