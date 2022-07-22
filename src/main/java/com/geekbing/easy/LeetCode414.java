package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode414 {
    public int thirdMax(int[] nums) {
        Integer max = null, second = null, third = null;
        for (int num : nums) {
            if (max == null) {
                max = num;
            } else if (num > max) {
                third = second;
                second = max;
                max = num;
            } else if (num == max) {
            } else if (second == null) {
                second = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num == second) {
            } else if (third == null) {
                third = num;
            } else if (num > third) {
                third = num;
            }
        }
        return third == null ? max : third;
    }

    public static void main(String[] args) {
        LeetCode414 leetCode414 = new LeetCode414();
        System.out.println(leetCode414.thirdMax(new int[]{3, 2, 1}));
        System.out.println(leetCode414.thirdMax(new int[]{1, 2}));
        System.out.println(leetCode414.thirdMax(new int[]{2, 2, 3, 1}));
    }
}
