package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * todo 超时
 *
 * @author bing
 */
public class LeetCode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int left = 0; left < nums.length; left++) {
            for (int right = left + 1; right <= Math.min(left + k, nums.length - 1); right++) {
                if (Math.abs((long) nums[left] - (long) nums[right]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert leetCode220.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

    @Test
    public void testCase2() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert leetCode220.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2);
    }

    @Test
    public void testCase3() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert !leetCode220.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }

    @Test
    public void testCase4() {
        LeetCode220 leetCode220 = new LeetCode220();
        assert !leetCode220.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1);
    }
}
