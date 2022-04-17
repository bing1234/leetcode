package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < preEnd) {
                return false;
            }
            preEnd = intervals[i][1];
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode252 leetCode252 = new LeetCode252();
        assert !leetCode252.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}});
    }

    @Test
    public void testCase2() {
        LeetCode252 leetCode252 = new LeetCode252();
        assert leetCode252.canAttendMeetings(new int[][]{{7, 10}, {2, 4}});
    }
}
