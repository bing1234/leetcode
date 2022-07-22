package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp[i][j] 表示使用(i,j)元素时最小的路径和
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = dp[dp.length - 1][0];
        for (int j = 0; j < dp[dp.length - 1].length; j++) {
            if (min > dp[dp.length - 1][j]) {
                min = dp[dp.length - 1][j];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode120 leetCode120 = new LeetCode120();
        List<List<Integer>> case1 = new ArrayList<>();
        case1.add(new ArrayList<>(Arrays.asList(2)));
        case1.add(new ArrayList<>(Arrays.asList(3, 4)));
        case1.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        case1.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(leetCode120.minimumTotal(case1));
    }
}
