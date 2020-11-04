package com.geekbing.hard;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/insert-interval/
 * 57. 插入区间
 *
 * @author bing
 */
public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length + 1][2];
        int idx = 0, left = newInterval[0], right = newInterval[1];
        boolean used = false;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                ans[idx++] = interval;
            } else if (interval[0] > newInterval[1]) {
                if (!used) {
                    ans[idx++] = new int[]{left, right};
                    used = true;
                }
                ans[idx++] = interval;
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!used) {
            ans[idx++] = new int[]{left, right};
        }
        return Arrays.copyOf(ans, idx);
    }

    public static void main(String[] args) {
        LeetCode57 leetCode57 = new LeetCode57();
        System.out.println(Arrays.deepToString(leetCode57.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(leetCode57.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }
}
