package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2016 {
    public int maximumDifference(int[] nums) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode2016 leetCode2016 = new LeetCode2016();
        assert leetCode2016.maximumDifference(new int[]{7, 1, 5, 4}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2016 leetCode2016 = new LeetCode2016();
        assert leetCode2016.maximumDifference(new int[]{9, 4, 3, 2}) == -1;
    }

    @Test
    public void testCase3() {
        LeetCode2016 leetCode2016 = new LeetCode2016();
        assert leetCode2016.maximumDifference(new int[]{1, 5, 2, 10}) == 9;
    }
}
