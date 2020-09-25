package com.geekbing.middle;

import java.util.Arrays;
import java.util.Comparator;

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

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();

        int[][] ans1 = leetCode56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] item : ans1) {
            System.out.println(Arrays.toString(item));
        }

        int[][] ans2 = leetCode56.merge(new int[][]{{1, 4}, {4, 5}});
        for (int[] item : ans2) {
            System.out.println(Arrays.toString(item));
        }

        int[][] ans3 = leetCode56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] item : ans3) {
            System.out.println(Arrays.toString(item));
        }
    }
}
