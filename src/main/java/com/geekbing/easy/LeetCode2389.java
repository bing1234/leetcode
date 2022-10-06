package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        int[] sums = preSum(nums);
        for (int i = 0; i < queries.length; i++) {
            ans[i] = maxSubSumLength(sums, queries[i]) + 1;
        }
        return ans;
    }

    private int[] preSum(int[] nums) {
        int sum = 0;
        int[] preSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        return preSum;
    }

    private int maxSubSumLength(int[] nums, int query) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < query) {
                left = mid + 1;
            } else if (nums[mid] == query) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] > query) {
            return left - 1;
        } else {
            return left;
        }
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