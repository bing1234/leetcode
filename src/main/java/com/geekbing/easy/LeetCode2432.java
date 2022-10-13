package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2432 {
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0], maxTime = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int time = logs[i][1] - logs[i - 1][1];
            if (time > maxTime) {
                maxTime = time;
                ans = logs[i][0];
            } else if (time == maxTime) {
                if (ans > logs[i][0]) {
                    ans = logs[i][0];
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2432 leetCode2432 = new LeetCode2432();
        int ans = leetCode2432.hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}});
        assert ans == 1;
    }

    @Test
    public void testCase2() {
        LeetCode2432 leetCode2432 = new LeetCode2432();
        int ans = leetCode2432.hardestWorker(10, new int[][]{{1, 1}, {3, 7}, {2, 12}, {7, 17}});
        assert ans == 3;
    }
}
