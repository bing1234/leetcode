package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode474 leetCode474 = new LeetCode474();
        assert leetCode474.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode474 leetCode474 = new LeetCode474();
        assert leetCode474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1) == 2;
    }
}
