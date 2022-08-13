package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + diff + diff)) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2367 leetCode2367 = new LeetCode2367();
        int ans = leetCode2367.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3);
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2367 leetCode2367 = new LeetCode2367();
        int ans = leetCode2367.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2);
        assert ans == 2;
    }
}
