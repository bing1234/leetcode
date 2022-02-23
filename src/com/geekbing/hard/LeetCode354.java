package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        // 按照左端点排序
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode354 leetCode354 = new LeetCode354();
        assert leetCode354.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode354 leetCode354 = new LeetCode354();
        assert leetCode354.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode354 leetCode354 = new LeetCode354();
        assert leetCode354.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}) == 4;
    }
}
