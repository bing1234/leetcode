package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2144 {
    public int minimumCost(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        Arrays.sort(cost);
        int ans = 0;
        int i = cost.length - 1;
        while (i >= 0) {
            ans += cost[i];
            if (i - 1 >= 0) {
                ans += cost[i - 1];
            }
            i -= 3;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2144 leetCode2144 = new LeetCode2144();
        assert leetCode2144.minimumCost(new int[]{1, 2, 3}) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode2144 leetCode2144 = new LeetCode2144();
        assert leetCode2144.minimumCost(new int[]{6, 5, 7, 9, 2, 2}) == 23;
    }

    @Test
    public void testCase3() {
        LeetCode2144 leetCode2144 = new LeetCode2144();
        assert leetCode2144.minimumCost(new int[]{5, 5}) == 10;
    }

    @Test
    public void testCase4() {
        LeetCode2144 leetCode2144 = new LeetCode2144();
        assert leetCode2144.minimumCost(new int[]{3, 3, 3, 1}) == 7;
    }
}
