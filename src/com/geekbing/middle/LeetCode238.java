package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length, prod = 1;

        int[] left = new int[len];
        left[0] = prod;
        for (int i = 0; i < len - 1; i++) {
            prod *= nums[i];
            left[i + 1] = prod;
        }

        int[] right = new int[len];
        prod = 1;
        right[len - 1] = prod;
        for (int i = len - 1; i >= 1; i--) {
            prod *= nums[i];
            right[i - 1] = prod;
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode238 leetCode238 = new LeetCode238();
        int[] ans = leetCode238.productExceptSelf(new int[]{1, 2, 3, 4});
        int[] expert = new int[]{24, 12, 8, 6};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode238 leetCode238 = new LeetCode238();
        int[] ans = leetCode238.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        int[] expert = new int[]{0, 0, 9, 0, 0};
        assert Arrays.equals(expert, ans);
    }
}
