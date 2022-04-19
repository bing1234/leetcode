package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1064 {
    public int fixedPoint(int[] arr) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1064 leetCode1064 = new LeetCode1064();
        assert leetCode1064.fixedPoint(new int[]{-10, -5, 0, 3, 7}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1064 leetCode1064 = new LeetCode1064();
        assert leetCode1064.fixedPoint(new int[]{0, 2, 5, 8, 17}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode1064 leetCode1064 = new LeetCode1064();
        assert leetCode1064.fixedPoint(new int[]{-10, -5, 3, 4, 7, 9}) == -1;
    }
}
