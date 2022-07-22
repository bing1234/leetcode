package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode821 {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        // 从左到右
        int idx = -len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }
        // 从右到左
        idx = 2 * len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode821 leetCode821 = new LeetCode821();
        int[] ans = leetCode821.shortestToChar("loveleetcode", 'e');
        int[] expert = new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode821 leetCode821 = new LeetCode821();
        int[] ans = leetCode821.shortestToChar("aaab", 'b');
        int[] expert = new int[]{3, 2, 1, 0};
        assert Arrays.equals(expert, ans);
    }
}
