package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode6160 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = countMaxLen(nums, queries[i]);
        }
        return ans;
    }

    private int countMaxLen(int[] nums, int query) {
        int ans = 0, sum = nums[0], left = 0, right = 0;

        while (right + 1 < nums.length) {
            while (right + 1 < nums.length && sum + nums[right + 1] < query) {
                right++;
                sum += nums[right];
                ans = Math.max(ans, right - left + 1);
            }
            while (left < right && sum > query) {
                sum -= nums[left];
                left++;
            }
            right++;
            if (right < nums.length) {
                sum += nums[right];
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6160 leetCode6160 = new LeetCode6160();
        int[] ans = leetCode6160.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
        int[] expert = new int[]{2, 3, 4};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode6160 leetCode6160 = new LeetCode6160();
        int[] ans = leetCode6160.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1});
        int[] expert = new int[]{0};
        assert Arrays.equals(ans, expert);
    }
}
