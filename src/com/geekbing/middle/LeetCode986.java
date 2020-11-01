package com.geekbing.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/interval-list-intersections/
 * 986. 区间列表的交集
 *
 * @author bing
 */
public class LeetCode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        return new int[][]{};
    }

    public static void main(String[] args) {
        LeetCode986 leetCode986 = new LeetCode986();
        System.out.println(Arrays.deepToString(leetCode986.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }
}
