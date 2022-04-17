package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode246 {
    public boolean isStrobogrammatic(String num) {
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert leetCode246.isStrobogrammatic("69");
    }

    @Test
    public void testCase2() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert leetCode246.isStrobogrammatic("88");
    }

    @Test
    public void testCase3() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert !leetCode246.isStrobogrammatic("962");
    }

    @Test
    public void testCase4() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert leetCode246.isStrobogrammatic("1");
    }
}
