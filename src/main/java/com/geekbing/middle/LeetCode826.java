package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // 难度和收益的对应关系
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }

        Arrays.sort(difficulty);
        Arrays.sort(worker);
        int ans = 0, idx = 0, best = 0;

        for (int work : worker) {
            while (idx < difficulty.length && work >= difficulty[idx]) {
                best = Math.max(best, map.get(difficulty[idx]));
                idx++;
            }
            ans += best;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode826 leetCode826 = new LeetCode826();
        int[] difficulty = new int[]{2, 4, 6, 8, 10};
        int[] profit = new int[]{10, 20, 30, 40, 50};
        int[] worker = new int[]{4, 5, 6, 7};
        int ans = leetCode826.maxProfitAssignment(difficulty, profit, worker);
        assert ans == 100;
    }

    @Test
    public void testCase2() {
        LeetCode826 leetCode826 = new LeetCode826();
        int[] difficulty = new int[]{85, 47, 57};
        int[] profit = new int[]{24, 66, 99};
        int[] worker = new int[]{40, 25, 25};
        int ans = leetCode826.maxProfitAssignment(difficulty, profit, worker);
        assert ans == 0;
    }

    @Test
    public void testCase3() {
        LeetCode826 leetCode826 = new LeetCode826();
        int[] difficulty = new int[]{66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63};
        int[] profit = new int[]{66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77};
        int[] worker = new int[]{61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16};
        int ans = leetCode826.maxProfitAssignment(difficulty, profit, worker);
        assert ans == 1392;
    }
}
