package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2123 {
    public int minMoves(int target, int maxDoubles) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode2123 leetCode2123 = new LeetCode2123();
        assert leetCode2123.minMoves(5, 0) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2123 leetCode2123 = new LeetCode2123();
        assert leetCode2123.minMoves(19, 2) == 7;
    }

    @Test
    public void testCase3() {
        LeetCode2123 leetCode2123 = new LeetCode2123();
        assert leetCode2123.minMoves(10, 4) == 4;
    }
}
