package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2395 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode2395 leetCode2395 = new LeetCode2395();
        assert leetCode2395.findSubarrays(new int[]{4,2,4});
    }

    @Test
    public void testCase2() {
        LeetCode2395 leetCode2395 = new LeetCode2395();
        assert !leetCode2395.findSubarrays(new int[]{1,2,3,4,5});
    }

    @Test
    public void testCase3() {
        LeetCode2395 leetCode2395 = new LeetCode2395();
        assert leetCode2395.findSubarrays(new int[]{0,0,0});
    }
}
