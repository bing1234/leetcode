package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * todo
 * @author bing
 */
public class LeetCode2149 {
    public int[] rearrangeArray(int[] nums) {
        return new int[]{};
    }

    @Test
    public void testCase1() {
        LeetCode2149 leetCode2149 = new LeetCode2149();
        int[] ans = leetCode2149.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4});
        int[] expert = new int[]{3, -2, 1, -5, 2, -4};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2149 leetCode2149 = new LeetCode2149();
        int[] ans = leetCode2149.rearrangeArray(new int[]{-1, 1});
        int[] expert = new int[]{1, -1};
        assert Arrays.equals(expert, ans);
    }
}
