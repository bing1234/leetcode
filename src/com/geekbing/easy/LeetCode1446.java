package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1446 {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        char pre = chars[0], cur;
        int curNum = 1, ans = 1;
        for (int i = 1; i < chars.length; i++) {
            cur = chars[i];
            if (cur == pre) {
                curNum++;
            } else {
                curNum = 1;
                pre = cur;
            }
            ans = Math.max(ans, curNum);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1446 leetCode1446 = new LeetCode1446();
        assert leetCode1446.maxPower("leetcode") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1446 leetCode1446 = new LeetCode1446();
        assert leetCode1446.maxPower("abbcccddddeeeeedcba") == 5;
    }

    @Test
    public void testCase3() {
        LeetCode1446 leetCode1446 = new LeetCode1446();
        assert leetCode1446.maxPower("triplepillooooow") == 5;
    }

    @Test
    public void testCase4() {
        LeetCode1446 leetCode1446 = new LeetCode1446();
        assert leetCode1446.maxPower("hooraaaaaaaaaaay") == 11;
    }

    @Test
    public void testCase5q() {
        LeetCode1446 leetCode1446 = new LeetCode1446();
        assert leetCode1446.maxPower("tourist") == 1;
    }
}
