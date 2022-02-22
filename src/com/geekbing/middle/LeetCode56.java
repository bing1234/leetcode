package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        // 按照左区间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));

        int index = -1;
        int[][] ans = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > ans[index][1]) {
                ans[++index] = interval;
            } else {
                ans[index][1] = Math.max(interval[1], ans[index][1]);
            }
        }
        return Arrays.copyOf(ans, index + 1);
    }

    @Test
    public void testCase1() {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] ans = leetCode56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] expert = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] ans = leetCode56.merge(new int[][]{{1, 4}, {4, 5}});
        int[][] expert = new int[][]{{1, 5}};
        assert Arrays.deepEquals(expert, ans);
    }
}
