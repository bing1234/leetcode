package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1086 {
    public int[][] highFive(int[][] items) {
        return new int[][]{};
    }

    @Test
    public void testCase1() {
        LeetCode1086 leetCode1086 = new LeetCode1086();
        int[][] ans = leetCode1086.highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}});
        int[][] expert = new int[][]{{1, 87}, {2, 88}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode1086 leetCode1086 = new LeetCode1086();
        int[][] ans = leetCode1086.highFive(new int[][]{{1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}});
        int[][] expert = new int[][]{{1, 100}, {7, 100}};
        assert Arrays.deepEquals(expert, ans);
    }
}
