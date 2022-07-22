package com.geekbing.easy;

import java.util.*;

public class LeetCode1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int distance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                List<Integer> arr = map.get(distance);
                if (arr == null) {
                    arr = new ArrayList<>();
                }
                arr.add(i);
                map.put(distance, arr);
            }
        }
        if (map.isEmpty()) {
            return -1;
        }
        int minDistance = Integer.MAX_VALUE;
        for (int distance : map.keySet()) {
            minDistance = Math.min(minDistance, distance);
        }
        return map.get(minDistance).get(0);
    }

    public static void main(String[] args) {
        LeetCode1779 leetCode1779 = new LeetCode1779();
        System.out.println(leetCode1779.nearestValidPoint(3, 4, new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}));
        System.out.println(leetCode1779.nearestValidPoint(3, 4, new int[][]{{3, 4}}));
        System.out.println(leetCode1779.nearestValidPoint(3, 4, new int[][]{{2, 3}}));
    }
}
