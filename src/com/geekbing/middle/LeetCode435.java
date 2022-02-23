package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[1]));
        int ans = 0, preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < preEnd) {
                ans++;
            } else {
                preEnd = intervals[i][1];
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode435 leetCode435 = new LeetCode435();
        assert leetCode435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode435 leetCode435 = new LeetCode435();
        assert leetCode435.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode435 leetCode435 = new LeetCode435();
        assert leetCode435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}) == 0;
    }
}
