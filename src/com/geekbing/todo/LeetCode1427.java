package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1427 {
    public String stringShift(String s, int[][] shift) {
        return "";
    }

    @Test
    public void testCase1() {
        LeetCode1427 leetCode1427 = new LeetCode1427();
        assert leetCode1427.stringShift("abc", new int[][]{{0, 1}, {1, 2}}).equals("cab");
    }

    @Test
    public void testCase2() {
        LeetCode1427 leetCode1427 = new LeetCode1427();
        assert leetCode1427.stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}).equals("efgabcd");
    }
}
