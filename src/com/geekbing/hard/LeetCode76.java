package com.geekbing.hard;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        // 参数检查
        if (s.length() < t.length()) {
            return "";
        }

        // 记录s1中每个字符出现的次数
        Map<Character, Integer> needMap = countCharacter(t);
        // 记录窗口内每个字符出现的次数
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        String ans = "";
        while (left <= right && right < s.length()) {
            char rightChar = s.charAt(right);
            window.merge(rightChar, 1, Integer::sum);
            if (cover(window, needMap)) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                left++;

                while (left <= right && !needMap.containsKey(s.charAt(left))) {
                    left++;
                }
                if (cover(window, needMap)) {
                    if (minLen > right - left + 1) {
                        minLen = right - left + 1;
                        ans = s.substring(left, right + 1);
                    }
                }
                right++;
            } else {
                right++;
            }
        }
        return ans;
    }

    private boolean cover(Map<Character, Integer> window, Map<Character, Integer> needMap) {
        for (Character key : needMap.keySet()) {
            if (!window.containsKey(key) || needMap.get(key) > window.get(key)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> countCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        // System.out.println(leetCode76.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(leetCode76.minWindow("ab", "b"));
    }
}
