package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode464 leetCode464 = new LeetCode464();
        assert !leetCode464.canIWin(10, 11);
    }

    @Test
    public void testCase2() {
        LeetCode464 leetCode464 = new LeetCode464();
        assert leetCode464.canIWin(10, 0);
    }

    @Test
    public void testCase3() {
        LeetCode464 leetCode464 = new LeetCode464();
        assert leetCode464.canIWin(10, 1);
    }
}
