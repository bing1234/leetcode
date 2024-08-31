package com.geekbing.easy;

import org.junit.jupiter.api.Test;

public class LeetCode2760Test {
    @Test
    public void case1() {
        LeetCode2760 leetCode2760 = new LeetCode2760();
        int ans = leetCode2760.longestAlternatingSubarray(new int[]{3, 2, 5, 4}, 5);
        assert ans == 3;
    }

    @Test
    public void case2() {
        LeetCode2760 leetCode2760 = new LeetCode2760();
        int ans = leetCode2760.longestAlternatingSubarray(new int[]{1, 2}, 2);
        assert ans == 1;
    }

    @Test
    public void case3() {
        LeetCode2760 leetCode2760 = new LeetCode2760();
        int ans = leetCode2760.longestAlternatingSubarray(new int[]{2, 3, 4, 5}, 4);
        assert ans == 3;
    }

    @Test
    public void case4() {
        LeetCode2760 leetCode2760 = new LeetCode2760();
        int ans = leetCode2760.longestAlternatingSubarray(new int[]{1, 3}, 16);
        assert ans == 0;
    }
}
