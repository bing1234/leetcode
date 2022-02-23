package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int ans = 1, preEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > preEnd) {
                ans++;
                preEnd = points[i][1];
            } else {
                preEnd = Math.min(preEnd, points[i][1]);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode452 leetCode452 = new LeetCode452();
        int ans = leetCode452.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode452 leetCode452 = new LeetCode452();
        int ans = leetCode452.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        assert ans == 4;
    }

    @Test
    public void testCase3() {
        LeetCode452 leetCode452 = new LeetCode452();
        int ans = leetCode452.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        assert ans == 2;
    }

    @Test
    public void testCase4() {
        LeetCode452 leetCode452 = new LeetCode452();
        int ans = leetCode452.findMinArrowShots(new int[][]{{1, 2}});
        assert ans == 1;
    }

    @Test
    public void testCase5() {
        LeetCode452 leetCode452 = new LeetCode452();
        int ans = leetCode452.findMinArrowShots(new int[][]{{2, 3}, {2, 3}});
        assert ans == 1;
    }
}
