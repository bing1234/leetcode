package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    @Test
    public void testCase1() {
        LeetCode2357 leetCode2357 = new LeetCode2357();
        assert leetCode2357.minimumOperations(new int[]{1, 5, 0, 3, 5}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2357 leetCode2357 = new LeetCode2357();
        assert leetCode2357.minimumOperations(new int[]{0}) == 0;
    }
}
