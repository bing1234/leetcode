package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        // 从小到大排序
        Arrays.sort(A);

        // 统计负数的数量
        int negativeCnt = 0;
        int idx = 0;
        while (idx < A.length && A[idx] < 0) {
            negativeCnt++;
            idx++;
        }

        int ans = 0;
        if (K <= negativeCnt) {
            for (int i = 0; i < A.length; i++) {
                if (i < K) {
                    ans += -A[i];
                } else {
                    ans += A[i];
                }
            }
            return ans;
        }

        for (int i = 0; i < A.length; i++) {
            if (i < negativeCnt) {
                ans += -A[i];
            } else {
                ans += A[i];
            }
        }
        int left = K - negativeCnt;
        if (left % 2 == 0) {
            return ans;
        }

        // 求绝对值最小的元素
        int min = Integer.MAX_VALUE;
        if (0 <= idx - 1 && idx - 1 < A.length) {
            min = Math.min(min, Math.abs(A[idx - 1]));
        }
        if (idx < A.length) {
            min = Math.min(min, Math.abs(A[idx]));
        }
        return ans - 2 * min;
    }

    @Test
    public void testCase1() {
        LeetCode1005 leetCode1005 = new LeetCode1005();
        assert leetCode1005.largestSumAfterKNegations(new int[]{4, 2, 3}, 1) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode1005 leetCode1005 = new LeetCode1005();
        assert leetCode1005.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3) == 6;
    }

    @Test
    public void testCase3() {
        LeetCode1005 leetCode1005 = new LeetCode1005();
        assert leetCode1005.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2) == 13;
    }
}
