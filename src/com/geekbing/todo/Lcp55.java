package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Lcp55 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int ans = 0;
        for (int[] arr : fruits) {
            if (arr[1] % limit == 0) {
                ans += time[arr[0]] * (arr[1] / limit);
            } else {
                ans += time[arr[0]] * (arr[1] / limit + 1);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        Lcp55 lcp55 = new Lcp55();
        assert lcp55.getMinimumTime(new int[]{2, 3, 2}, new int[][]{{0, 2}, {1, 4}, {2, 1}}, 3) == 10;
    }

    @Test
    public void testCase2() {
        Lcp55 lcp55 = new Lcp55();
        assert lcp55.getMinimumTime(new int[]{1}, new int[][]{{0, 3}, {0, 5}}, 2) == 5;
    }
}
