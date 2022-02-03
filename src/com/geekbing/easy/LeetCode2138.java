package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode2138 {
    public String[] divideString(String s, int k, char fill) {
        String[] ans = new String[]{};
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
