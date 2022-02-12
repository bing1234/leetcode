package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1545 {
    private static List<char[]> list = new ArrayList<>();

    static {
        char[] chars = new char[]{'0'};
        list.add(chars);
        for (int i = 0; i < 20; i++) {
            chars = geneNext(chars);
            list.add(chars);
        }
    }

    public char findKthBit(int n, int k) {
        return list.get(n)[k - 1];
    }

    private static char[] invert(char[] chars) {
        char[] ans = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ans[i] = chars[i] == '0' ? '1' : '0';
        }
        return ans;
    }

    private static char[] reverse(char[] chars) {
        char[] ans = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ans[i] = chars[chars.length - i - 1];
        }
        return ans;
    }

    private static char[] geneNext(char[] chars) {
        char[] ans = new char[2 * chars.length + 1];
        char[] temps = reverse(invert(chars));
        int idx = 0;
        for (char aChar : chars) {
            ans[idx++] = aChar;
        }
        ans[idx++] = '1';
        for (char temp : temps) {
            ans[idx++] = temp;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1545 leetCode1545 = new LeetCode1545();
        assert leetCode1545.findKthBit(3, 1) == '0';
    }

    @Test
    public void testCase2() {
        LeetCode1545 leetCode1545 = new LeetCode1545();
        assert leetCode1545.findKthBit(4, 11) == '1';
    }

    @Test
    public void testCase3() {
        LeetCode1545 leetCode1545 = new LeetCode1545();
        assert leetCode1545.findKthBit(1, 1) == '0';
    }

    @Test
    public void testCase4() {
        LeetCode1545 leetCode1545 = new LeetCode1545();
        assert leetCode1545.findKthBit(2, 3) == '1';
    }

    @Test
    public void testCase5() {
        LeetCode1545 leetCode1545 = new LeetCode1545();
        assert leetCode1545.findKthBit(20, 1048575) == '1';
    }
}
