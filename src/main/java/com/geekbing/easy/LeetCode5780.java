package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode5780 {
    public boolean canBeIncreasing(int[] nums) {
        // 特殊情况处理
        if (nums.length < 2) {
            return true;
        }
        if (nums.length == 2 && nums[0] < nums[1]) {
            return true;
        }
        // 不符合严格递增要求的下标
        Integer idx = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                if (idx != null) {
                    return false;
                }
                idx = i;
            }
        }
        if (idx == null) {
            return true;
        }
        if (idx == 0 || idx == nums.length - 2) {
            return true;
        }
        // 可能是idx不符合要求，也可能是idx+1不符合要求
        if (idx + 1 < nums.length && nums[idx - 1] < nums[idx + 1]) {
            return true;
        }
        return idx + 2 < nums.length && nums[idx] < nums[idx + 2];
    }

    public static void main(String[] args) {
        LeetCode5780 leetCode5780 = new LeetCode5780();

        System.out.println(leetCode5780.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(leetCode5780.canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(leetCode5780.canBeIncreasing(new int[]{1, 1, 1}));
        System.out.println(leetCode5780.canBeIncreasing(new int[]{1, 2, 3}));
        System.out.println(leetCode5780.canBeIncreasing(new int[]{105, 924, 32, 968}));
        System.out.println(leetCode5780.canBeIncreasing(new int[]{512, 867, 904, 997, 403}));

    }
}
