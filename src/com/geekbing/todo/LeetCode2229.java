package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2229 {
    public boolean isConsecutive(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        return max - min == set.size() - 1 && nums.length == set.size();
    }

    @Test
    public void testCase1() {
        LeetCode2229 leetCode2229 = new LeetCode2229();
        assert leetCode2229.isConsecutive(new int[]{1, 3, 4, 2});
    }

    @Test
    public void testCase2() {
        LeetCode2229 leetCode2229 = new LeetCode2229();
        assert !leetCode2229.isConsecutive(new int[]{1, 3});
    }

    @Test
    public void testCase3() {
        LeetCode2229 leetCode2229 = new LeetCode2229();
        assert leetCode2229.isConsecutive(new int[]{3, 5, 4});
    }
}
