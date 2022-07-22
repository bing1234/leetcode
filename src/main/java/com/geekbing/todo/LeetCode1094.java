package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> list = new ArrayList<>();
        for (int[] trip : trips) {
            list.add(new int[]{trip[1], trip[0]});
            list.add(new int[]{trip[2], -trip[0]});
        }
        list.sort(((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        int cnt = 0;
        for (int[] item : list) {
            cnt += item[1];
            if (cnt > capacity) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode1094 leetCode1094 = new LeetCode1094();
        assert !leetCode1094.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4);
    }

    @Test
    public void testCase2() {
        LeetCode1094 leetCode1094 = new LeetCode1094();
        assert leetCode1094.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5);
    }
}
