package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2119 {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }

    @Test
    public void testCase1() {
        LeetCode2119 leetCode2119 = new LeetCode2119();
        assert leetCode2119.isSameAfterReversals(526);
    }

    @Test
    public void testCase2() {
        LeetCode2119 leetCode2119 = new LeetCode2119();
        assert !leetCode2119.isSameAfterReversals(1800);
    }

    @Test
    public void testCase3() {
        LeetCode2119 leetCode2119 = new LeetCode2119();
        assert leetCode2119.isSameAfterReversals(0);
    }
}
