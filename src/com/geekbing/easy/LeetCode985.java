package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int total = Arrays.stream(A).filter(num -> num % 2 == 0).sum();

        int val, index;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            val = queries[i][0];
            index = queries[i][1];
            if (A[index] % 2 == 0 && val % 2 == 0) {
                total += val;
                ans[i] = total;
            } else if (A[index] % 2 != 0 && val % 2 != 0) {
                total += A[index] + val;
            } else if (A[index] % 2 == 0) {
                total = total - A[index];
                ans[i] = total;
            }
            ans[i] = total;
            A[index] += val;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode985 leetCode985 = new LeetCode985();
        System.out.println(Arrays.toString(leetCode985.sumEvenAfterQueries(new int[]{1},
                new int[][]{{4, 0}})));
        System.out.println(Arrays.toString(leetCode985.sumEvenAfterQueries(new int[]{1, 2, 3, 4},
                new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }
}
