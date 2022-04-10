package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode473 {
    public boolean makesquare(int[] matchsticks) {
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode473 leetCode473 = new LeetCode473();
        assert leetCode473.makesquare(new int[]{1, 1, 2, 2, 2});
    }

    @Test
    public void testCase2() {
        LeetCode473 leetCode473 = new LeetCode473();
        assert !leetCode473.makesquare(new int[]{3, 3, 3, 3, 4});
    }
}
