package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author bing
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        while (left <= right && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
            } else {
                while (true) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        break;
                    } else {
                        set.remove(s.charAt(left));
                        left++;
                    }
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    @Test
    public void testCase1() {
        LeetCode3 leetCode3 = new LeetCode3();
        assert leetCode3.lengthOfLongestSubstring("abcabcbb") == 3;
    }

    @Test
    public void testCase2() {
        LeetCode3 leetCode3 = new LeetCode3();
        assert leetCode3.lengthOfLongestSubstring("bbbbb") == 1;
    }

    @Test
    public void testCase3() {
        LeetCode3 leetCode3 = new LeetCode3();
        assert leetCode3.lengthOfLongestSubstring("pwwkew") == 3;
    }

    @Test
    public void testCase4() {
        LeetCode3 leetCode3 = new LeetCode3();
        assert leetCode3.lengthOfLongestSubstring("") == 0;
    }
}
