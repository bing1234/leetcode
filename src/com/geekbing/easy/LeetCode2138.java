package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2138 {
    public String[] divideString(String s, int k, char fill) {
        int len = (s.length() % k == 0) ? s.length() / k : s.length() / k + 1;
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            ans[i] = s.substring(i * k, Math.min((i + 1) * k, s.length()));
        }
        char[] remain = new char[k - ans[len - 1].length()];
        Arrays.fill(remain, fill);
        ans[len - 1] += new String(remain);
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2138 leetCode2138 = new LeetCode2138();
        String[] ans = leetCode2138.divideString("abcdefghi", 3, 'x');
        String[] expert = new String[]{"abc", "def", "ghi"};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2138 leetCode2138 = new LeetCode2138();
        String[] ans = leetCode2138.divideString("abcdefghij", 3, 'x');
        String[] expert = new String[]{"abc", "def", "ghi", "jxx"};
        assert Arrays.equals(expert, ans);
    }
}
