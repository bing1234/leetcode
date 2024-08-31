package com.geekbing.easy;

import org.junit.jupiter.api.Test;

public class LeetCode2778Test {
    @Test
    public void case1() {
        LeetCode2778 leetCode2778 = new LeetCode2778();
        int ans = leetCode2778.sumOfSquares(new int[]{1, 2, 3, 4});
        assert ans == 21;
    }

    @Test
    public void case2() {
        LeetCode2778 leetCode2778 = new LeetCode2778();
        int ans = leetCode2778.sumOfSquares(new int[]{2, 7, 1, 19, 18, 3});
        assert ans == 63;
    }
}
