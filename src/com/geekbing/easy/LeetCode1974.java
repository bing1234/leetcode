package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1974 {
    public int minTimeToType(String word) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1974 leetCode1974 = new LeetCode1974();
        int ans = leetCode1974.minTimeToType("abc");
        assert ans == 5;
    }

    @Test
    public void testCase2() {
        LeetCode1974 leetCode1974 = new LeetCode1974();
        int ans = leetCode1974.minTimeToType("bza");
        assert ans == 7;
    }

    @Test
    public void testCase3() {
        LeetCode1974 leetCode1974 = new LeetCode1974();
        int ans = leetCode1974.minTimeToType("zjpc");
        assert ans == 34;
    }
}
