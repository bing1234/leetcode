package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1996 {
    public int numberOfWeakCharacters(int[][] properties) {

        System.out.println(properties);
        int ans = 0;

        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1996 leetCode1996 = new LeetCode1996();
        assert leetCode1996.numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode1996 leetCode1996 = new LeetCode1996();
        assert leetCode1996.numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1996 leetCode1996 = new LeetCode1996();
        assert leetCode1996.numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}) == 1;
    }
}
