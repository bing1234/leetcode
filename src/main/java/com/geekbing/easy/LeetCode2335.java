package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2335 {
    public int fillCups(int[] amount) {
        int ans = 0;
        while (amount[0] > 0 && amount[1] > 0 && amount[2] > 0) {
            Arrays.sort(amount);
            amount[1] -= 1;
            amount[2] -= 1;
            ans++;
        }
        Arrays.sort(amount);
        ans += Math.max(amount[1], amount[2]);
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2335 leetCode2335 = new LeetCode2335();
        int ans = leetCode2335.fillCups(new int[]{1, 4, 2});
        assert ans == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2335 leetCode2335 = new LeetCode2335();
        int ans = leetCode2335.fillCups(new int[]{5, 4, 4});
        assert ans == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2335 leetCode2335 = new LeetCode2335();
        int ans = leetCode2335.fillCups(new int[]{5, 0, 0});
        assert ans == 5;
    }
}
