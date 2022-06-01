package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2044 {
    private int ans = 0;

    public int countMaxOrSubsets(int[] nums) {
        // 得到最大的或
        int max = Arrays.stream(nums).reduce(0, (a, b) -> a | b);
        backtrack(nums, 0, 0, max);
        return ans;
    }

    private void backtrack(int[] nums, int idx, int or, int max) {
        if (idx == nums.length) {
            if (or == max) {
                ans++;
            }
            return;
        }
        // 选择当前元素
        backtrack(nums, idx + 1, or | nums[idx], max);
        // 不选择当前元素
        backtrack(nums, idx + 1, or, max);
    }

    @Test
    public void testCase1() {
        LeetCode2044 leetCode2044 = new LeetCode2044();
        int ans = leetCode2044.countMaxOrSubsets(new int[]{3, 1});
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2044 leetCode2044 = new LeetCode2044();
        int ans = leetCode2044.countMaxOrSubsets(new int[]{2, 2, 2});
        assert ans == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2044 leetCode2044 = new LeetCode2044();
        int ans = leetCode2044.countMaxOrSubsets(new int[]{3, 2, 1, 5});
        assert ans == 6;
    }
}
