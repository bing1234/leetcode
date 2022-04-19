package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1134 {
    public boolean isArmstrong(int n) {
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode1134 leetCode1134 = new LeetCode1134();
        assert leetCode1134.isArmstrong(153);
    }

    @Test
    public void testCase2() {
        LeetCode1134 leetCode1134 = new LeetCode1134();
        assert !leetCode1134.isArmstrong(123);
    }
}
