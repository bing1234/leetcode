package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1180 {
    public int countLetters(String s) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1180 leetCode1180 = new LeetCode1180();
        assert leetCode1180.countLetters("aaaba") == 8;
    }

    @Test
    public void testCase2() {
        LeetCode1180 leetCode1180 = new LeetCode1180();
        assert leetCode1180.countLetters("aaaaaaaaaa") == 55;
    }
}
