package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2460 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int[] ans = new int[nums.length];
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                ans[idx++] = num;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2460 leetCode2460 = new LeetCode2460();
        int[] ans = leetCode2460.applyOperations(new int[]{1, 2, 2, 1, 1, 0});
        int[] expert = new int[]{1, 4, 2, 0, 0, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2460 leetCode2460 = new LeetCode2460();
        int[] ans = leetCode2460.applyOperations(new int[]{0, 1});
        int[] expert = new int[]{1, 0};
        assert Arrays.equals(expert, ans);
    }
}
