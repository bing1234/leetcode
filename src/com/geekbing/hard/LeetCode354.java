package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode354 {
    public int maxEnvelopesV2(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        int[] dp = new int[envelopes.length + 1];
        dp[0] = envelopes[0][1];
        int len = 1;
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > dp[len - 1]) {
                dp[len] = envelopes[i][1];
                len++;
            } else {
                int idx = binarySearch(dp, len, envelopes[i][1]);
                dp[idx] = envelopes[i][1];
            }
        }
        return len;
    }

    private static int binarySearch(int[] dp, int len, int target) {
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

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
        assert leetCode354.maxEnvelopesV2(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode354 leetCode354 = new LeetCode354();
        assert leetCode354.maxEnvelopesV2(new int[][]{{1, 1}, {1, 1}, {1, 1}}) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode354 leetCode354 = new LeetCode354();
        assert leetCode354.maxEnvelopesV2(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}) == 4;
    }

    @Test
    public void testCase4() {
        LeetCode354 leetCode354 = new LeetCode354();
        assert leetCode354.maxEnvelopesV2(new int[][]{{1, 15}, {7, 18}, {7, 6}, {7, 100}, {2, 200}, {17, 30}, {17, 45}, {3, 5}, {7, 8}, {3, 6}, {3, 10}, {7, 20}, {17, 3}, {17, 45}}) == 3;
    }
}
