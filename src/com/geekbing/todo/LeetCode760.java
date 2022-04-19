package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        return new int[]{};
    }

    @Test
    public void testCase1() {
        LeetCode760 leetCode760 = new LeetCode760();
        int[] ans = leetCode760.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28});
        int[] expert = new int[]{1, 4, 3, 2, 0};
        assert Arrays.equals(expert, ans);
    }
}
