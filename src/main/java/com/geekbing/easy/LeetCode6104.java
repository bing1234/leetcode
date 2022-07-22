package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode6104 {
    public int countAsterisks(String s) {
        String[] items = s.split("\\|");
        int ans = 0;
        for (int i = 0; i < items.length; i += 2) {
            ans += countChar(items[i]);
        }
        return ans;
    }

    private int countChar(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6104 leetCode6104 = new LeetCode6104();
        assert leetCode6104.countAsterisks("l|*e*et|c**o|*de|") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode6104 leetCode6104 = new LeetCode6104();
        assert leetCode6104.countAsterisks("iamprogrammer") == 0;
    }

    @Test
    public void testCase3() {
        LeetCode6104 leetCode6104 = new LeetCode6104();
        assert leetCode6104.countAsterisks("yo|uar|e**|b|e***au|tifu|l") == 5;
    }
}
