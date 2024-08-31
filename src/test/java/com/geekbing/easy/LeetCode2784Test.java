package com.geekbing.easy;

import org.junit.jupiter.api.Test;

public class LeetCode2784Test {
    @Test
    public void case1() {
        LeetCode2784 leetCode2784 = new LeetCode2784();
        boolean ans = leetCode2784.isGood(new int[]{2, 1, 3});
        assert !ans;
    }

    @Test
    public void case2() {
        LeetCode2784 leetCode2784 = new LeetCode2784();
        boolean ans = leetCode2784.isGood(new int[]{1, 3, 3, 2});
        assert ans;
    }

    @Test
    public void case3() {
        LeetCode2784 leetCode2784 = new LeetCode2784();
        boolean ans = leetCode2784.isGood(new int[]{1, 1});
        assert ans;
    }

    @Test
    public void case4() {
        LeetCode2784 leetCode2784 = new LeetCode2784();
        boolean ans = leetCode2784.isGood(new int[]{3, 4, 4, 1, 2, 1});
        assert !ans;
    }

    @Test
    public void case5() {
        LeetCode2784 leetCode2784 = new LeetCode2784();
        boolean ans = leetCode2784.isGood(new int[]{2, 2, 2});
        assert !ans;
    }
}
