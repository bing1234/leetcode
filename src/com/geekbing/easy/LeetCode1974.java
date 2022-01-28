package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1974 {
    public int minTimeToType(String word) {
        int ans = 0;
        char[] chars = word.toCharArray();
        char pre = 'a';
        for (char c : chars) {
            ans += calDistance(pre, c);
            ans++;
            pre = c;
        }
        return ans;
    }

    private int calDistance(char i, char j) {
        return i >= j ? Math.min(i - j, j + 26 - i) : Math.min(j - i, i + 26 - j);
    }

    @Test
    public void testCase1() {
        LeetCode1974 leetCode1974 = new LeetCode1974();
        assert leetCode1974.minTimeToType("abc") == 5;
    }

    @Test
    public void testCase2() {
        LeetCode1974 leetCode1974 = new LeetCode1974();
        assert leetCode1974.minTimeToType("bza") == 7;
    }

    @Test
    public void testCase3() {
        LeetCode1974 leetCode1974 = new LeetCode1974();
        assert leetCode1974.minTimeToType("zjpc") == 34;
    }
}
