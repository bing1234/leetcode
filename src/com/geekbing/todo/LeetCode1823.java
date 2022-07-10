package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1823 {
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n];
        // 当前位置下标
        int idx = 0;
        // 每一轮剔除一个数
        for (int i = 0; i < n - 1; i++) {
            int cnt = 0;
            while (true) {
                if (arr[idx] == 0) {
                    cnt++;
                    if (cnt == k) {
                        break;
                    }
                }
                idx++;
                if (idx == n) {
                    idx = 0;
                }
            }
            arr[idx] = -1;
            idx++;
            if (idx == n) {
                idx = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                return i + 1;
            }
        }
        return 1;
    }

    @Test
    public void testCase1() {
        LeetCode1823 leetCode1823 = new LeetCode1823();
        assert leetCode1823.findTheWinner(5, 2) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1823 leetCode1823 = new LeetCode1823();
        assert leetCode1823.findTheWinner(6, 5) == 1;
    }
}
