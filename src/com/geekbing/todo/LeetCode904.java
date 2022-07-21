package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode904 {
    public int totalFruit(int[] fruits) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{1, 2, 1}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{0, 1, 2, 2}) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{1, 2, 3, 2, 2}) == 4;
    }

    @Test
    public void testCase4() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}) == 5;
    }
}
