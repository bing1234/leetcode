package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode542 {
    public int[][] updateMatrix(int[][] mat) {
        return new int[][]{};
    }

    @Test
    public void testCase1() {
        LeetCode542 leetCode542 = new LeetCode542();
        int[][] ans = leetCode542.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
        int[][] expert = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode542 leetCode542 = new LeetCode542();
        int[][] ans = leetCode542.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        int[][] expert = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };
        assert Arrays.deepEquals(expert, ans);
    }
}
