package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 57. 插入区间
 *
 * @author bing
 */
public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 先合并intervals与newInterval
        int[][] temp = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, temp, 0, intervals.length);
        temp[temp.length - 1] = newInterval;

        // 按照左端点从小到大合并
        Arrays.sort(temp, Comparator.comparing(o -> o[0]));

        int[][] ans = new int[temp.length][2];
        ans[0] = temp[0];
        int idx = 0;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i][0] > ans[idx][1]) {
                idx++;
                ans[idx] = temp[i];
            } else {
                ans[idx][1] = Math.max(ans[idx][1], temp[i][1]);
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }

    @Test
    public void testCase1() {
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] ans = leetCode57.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        int[][] expert = new int[][]{{1, 5}, {6, 9}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] ans = leetCode57.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        int[][] expert = new int[][]{{1, 2}, {3, 10}, {12, 16}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] ans = leetCode57.insert(new int[][]{}, new int[]{5, 7});
        int[][] expert = new int[][]{{5, 7}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase4() {
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] ans = leetCode57.insert(new int[][]{{1, 5}}, new int[]{2, 3});
        int[][] expert = new int[][]{{1, 5}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase5() {
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] ans = leetCode57.insert(new int[][]{{1, 5}}, new int[]{2, 7});
        int[][] expert = new int[][]{{1, 7}};
        assert Arrays.deepEquals(expert, ans);
    }
}
