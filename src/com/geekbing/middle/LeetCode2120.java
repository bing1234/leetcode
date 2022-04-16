package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = executeInstruction(n, startPos, s, i);
        }
        return ans;
    }

    private int executeInstruction(int n, int[] startPos, String s, int idx) {
        int x = startPos[0], y = startPos[1], count = 0;
        for (int i = idx; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'U':
                    x--;
                    break;
                case 'D':
                    x++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                default:
                    break;
            }
            if (x < 0 || x >= n || y < 0 || y >= n) {
                return count;
            }
            count++;
        }
        return count;
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
