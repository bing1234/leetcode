package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * todo
 * @author bing
 */
public class LeetCode2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        return new int[]{};
    }

    @Test
    public void testCase1() {
        LeetCode2161 leetCode2161 = new LeetCode2161();
        int[] ans = leetCode2161.pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10);
        int[] expert = new int[]{9, 5, 3, 10, 10, 12, 14};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2161 leetCode2161 = new LeetCode2161();
        int[] ans = leetCode2161.pivotArray(new int[]{-3, 4, 3, 2}, 2);
        int[] expert = new int[]{-3, 2, 4, 3};
        assert Arrays.equals(expert, ans);
    }
}
