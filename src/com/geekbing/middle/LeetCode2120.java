package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * todo
 * @author bing
 */
public class LeetCode2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        return new int[]{};
    }

    @Test
    public void testCase1() {
        LeetCode2120 leetCode2120 = new LeetCode2120();
        int[] ans = leetCode2120.executeInstructions(3, new int[]{0, 1}, "RRDDLU");
        int[] expert = new int[]{1, 5, 4, 3, 1, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2120 leetCode2120 = new LeetCode2120();
        int[] ans = leetCode2120.executeInstructions(2, new int[]{1, 1}, "LURD");
        int[] expert = new int[]{4, 1, 0, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode2120 leetCode2120 = new LeetCode2120();
        int[] ans = leetCode2120.executeInstructions(1, new int[]{0, 0}, "LRUD");
        int[] expert = new int[]{0, 0, 0, 0};
        assert Arrays.equals(expert, ans);
    }
}
