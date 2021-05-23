package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 *
 * @author bing
 */
public class LeetCode447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    map.merge(countLen(points[i], points[j]), 1, Integer::sum);
                }
            }
            for (int key : map.keySet()) {
                int count = map.get(key);
                ans += (count - 1) * count;
            }
        }
        return ans;
    }

    private int countLen(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        LeetCode447 leetCode447 = new LeetCode447();

        System.out.println(leetCode447.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        System.out.println(leetCode447.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}}));
    }
}
