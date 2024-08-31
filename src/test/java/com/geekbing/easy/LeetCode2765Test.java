package com.geekbing.easy;

import org.junit.jupiter.api.Test;

public class LeetCode2765Test {
    @Test
    public void case1() {
        LeetCode2765 leetCode2765 = new LeetCode2765();
        int ans = leetCode2765.alternatingSubarray(new int[]{2, 3, 4, 3, 4});
        assert ans == 4;
    }

    @Test
    public void case2() {
        LeetCode2765 leetCode2765 = new LeetCode2765();
        int ans = leetCode2765.alternatingSubarray(new int[]{4, 5, 6});
        assert ans == 2;
    }
}
