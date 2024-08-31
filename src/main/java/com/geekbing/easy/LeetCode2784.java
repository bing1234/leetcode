package com.geekbing.easy;

public class LeetCode2784 {
    public boolean isGood(int[] nums) {
        int[] cache = new int[nums.length];
        for (int num : nums) {
            if (num > nums.length - 1) {
                return false;
            }
            if (cache[num] > 1) {
                return false;
            }
            if (cache[num] == 1 && num != nums.length - 1) {
                return false;
            }
            cache[num]++;
        }
        return true;
    }
}
