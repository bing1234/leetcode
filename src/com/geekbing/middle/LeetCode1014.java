package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1014 {
    public int maxScoreSightseeingPair(int[] values) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1014 leetCode1014 = new LeetCode1014();
        assert leetCode1014.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}) == 11;
    }

    @Test
    public void testCase2() {
        LeetCode1014 leetCode1014 = new LeetCode1014();
        assert leetCode1014.maxScoreSightseeingPair(new int[]{1, 2}) == 2;
    }
}
