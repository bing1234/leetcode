package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = maxSubSumLength(nums, queries[i]);
        }
        return ans;
    }

    private int maxSubSumLength(int[] nums, int query) {
        int right = 0;
        // 找到第一个小于query的数字
        while (right < nums.length && nums[right] > query) {
            right++;
        }
        if (right == nums.length) {
            return 0;
        }

        int sum = nums[right], left = right, ans = 1;
        while (right < nums.length) {
            while (right + 1 < nums.length && sum + nums[right + 1] <= query) {
                right++;
                sum += nums[right];
                ans = Math.max(ans, right - left + 1);
            }

            if (sum <= query) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2389 leetCode2389 = new LeetCode2389();
        int[] ans = leetCode2389.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
        int[] expert = new int[]{2, 3, 4};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2389 leetCode2389 = new LeetCode2389();
        int[] ans = leetCode2389.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1});
        int[] expert = new int[]{0};
        assert Arrays.equals(expert, ans);
    }
}
