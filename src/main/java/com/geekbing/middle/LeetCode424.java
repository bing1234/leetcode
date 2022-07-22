package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode424 {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        int ans = k;
        for (Character c : set) {
            if (k == 0) {
                ans = Math.max(ans, allSame(s, c));
            } else {
                ans = Math.max(ans, replaceTarget(s, c, k));
            }
        }
        return ans;
    }

    private int allSame(String s, char targetChar) {
        int ans = 0, curCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == targetChar) {
                curCnt++;
                ans = Math.max(ans, curCnt);
            } else {
                curCnt = 0;
            }
        }
        return ans;
    }

    private int replaceTarget(String s, char targetChar, int k) {
        // 维护一个滑动窗口
        int left = 0, right = 0, ans = k;
        if (s.charAt(0) != targetChar) {
            k--;
        }
        while (right + 1 < s.length()) {
            // 如果右边是目标字符，则直接扩张
            if (right + 1 < s.length() && s.charAt(right + 1) == targetChar) {
                right++;
                ans = Math.max(ans, right + 1 - left);
            } else {
                // 右边不是目标字符
                if (right + 1 < s.length() && k > 0) {
                    // 还有替换次数的话
                    k--;
                    right++;
                    ans = Math.max(ans, right + 1 - left);
                } else {
                    // 没有替换次数了，则左边收缩
                    if (s.charAt(left) == targetChar) {
                        left++;
                    } else {
                        left++;
                        k++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode424 leetCode424 = new LeetCode424();
        assert leetCode424.characterReplacement("ABAB", 2) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode424 leetCode424 = new LeetCode424();
        assert leetCode424.characterReplacement("AABABBA", 1) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode424 leetCode424 = new LeetCode424();
        int ans = leetCode424.characterReplacement("BAAA", 0);
        assert ans == 3;
    }

    @Test
    public void testCase4() {
        LeetCode424 leetCode424 = new LeetCode424();
        int ans = leetCode424.characterReplacement("AABA", 0);
        assert ans == 2;
    }
}
