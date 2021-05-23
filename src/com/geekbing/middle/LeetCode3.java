package com.geekbing.middle;

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

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("aab"));
        System.out.println(leetCode3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(leetCode3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(leetCode3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(leetCode3.lengthOfLongestSubstring("tmmzuxt"));
    }
}
