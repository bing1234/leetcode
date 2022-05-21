package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] ans = new int[]{};

        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode803 leetCode803 = new LeetCode803();
        int[] ans = leetCode803.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 0}});
        int[] expert = new int[]{2};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode803 leetCode803 = new LeetCode803();
        int[] ans = leetCode803.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}}, new int[][]{{1, 1}, {1, 0}});
        int[] expert = new int[]{0, 0};
        assert Arrays.equals(expert, ans);
    }
}
