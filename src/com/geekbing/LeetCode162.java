package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode162 leetCode162 = new LeetCode162();
        assert leetCode162.findPeakElement(new int[]{1, 2, 3, 1}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode162 leetCode162 = new LeetCode162();
        int ans = leetCode162.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        Set<Integer> expert = new HashSet<>(Arrays.asList(1, 5));
        assert expert.contains(ans);
    }
}
