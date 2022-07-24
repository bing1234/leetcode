package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
            ans ^= nums[i];
            ans ^= nums[i];
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode137 leetCode137 = new LeetCode137();
        int ans = leetCode137.singleNumber(new int[]{2, 2, 3, 2});
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode137 leetCode137 = new LeetCode137();
        int ans = leetCode137.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});
        assert ans == 99;
    }
}
