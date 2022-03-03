package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
        for (int three : nums) {
            if (three > two) {
                return true;
            } else if (three <= one) {
                one = three;
            } else {
                two = three;
            }
        }
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode334 leetCode334 = new LeetCode334();
        assert leetCode334.increasingTriplet(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testCase2() {
        LeetCode334 leetCode334 = new LeetCode334();
        assert !leetCode334.increasingTriplet(new int[]{5, 4, 3, 2, 1});
    }

    @Test
    public void testCase3() {
        LeetCode334 leetCode334 = new LeetCode334();
        assert leetCode334.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6});
    }

    @Test
    public void testCase4() {
        LeetCode334 leetCode334 = new LeetCode334();
        assert leetCode334.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13});
    }
}
