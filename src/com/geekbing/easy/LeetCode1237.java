package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/submissions/
 * 1237. 找出给定方程的正整数解
 *
 * @author bing
 */
public class LeetCode1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 从右上角开始搜索
        int row = 1, col = 1000;
        List<List<Integer>> ans = new ArrayList<>();
        while (row <= 1000 && col >= 1) {
            int res = customfunction.f(row, col);
            if (res < z) {
                row++;
            } else if (res == z) {
                ans.add(new ArrayList<>(Arrays.asList(row, col)));
                col--;
            } else {
                col--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CustomFunction customFunction = new CustomFunction();

        LeetCode1237 leetCode1237 = new LeetCode1237();
        System.out.println(leetCode1237.findSolution(customFunction, 5));
    }

    private static class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x + y;
        }
    }
}
