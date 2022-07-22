package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int valNum = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                valNum++;
                step++;
            } else {
                nums[i - step] = nums[i];
            }
        }
        return nums.length - valNum;
    }

    public static void main(String[] args) {
        LeetCode27 leetCode27 = new LeetCode27();
        System.out.println(leetCode27.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(leetCode27.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
