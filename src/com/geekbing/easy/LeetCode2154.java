package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2154 {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

    @Test
    public void testCase1() {
        LeetCode2154 leetCode2154 = new LeetCode2154();
        assert leetCode2154.findFinalValue(new int[]{5, 3, 6, 1, 12}, 3) == 24;
    }

    @Test
    public void testCase2() {
        LeetCode2154 leetCode2154 = new LeetCode2154();
        assert leetCode2154.findFinalValue(new int[]{2, 7, 9}, 4) == 4;
    }
}
