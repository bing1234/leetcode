package com.geekbing.middle;

import java.util.HashMap;
import java.util.Map;

public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        // 参数检查
        if (s1.length() > s2.length()) {
            return false;
        }

        // 记录s1中每个字符出现的次数
        Map<Character, Integer> needMap = countCharacter(s1);
        // 记录窗口内每个字符出现的次数
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        while (left <= right && right < s2.length()) {
            char rightChar = s2.charAt(right);
            if (right - left + 1 < s1.length()) {
                window.merge(rightChar, 1, Integer::sum);

                right++;
            } else {
                window.merge(rightChar, 1, Integer::sum);
                if (cover(window, needMap)) {
                    return true;
                }
                char leftChar = s2.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                left++;
                right++;
            }
        }
        return false;
    }

    private boolean cover(Map<Character, Integer> window, Map<Character, Integer> needMap) {
        for (Character key : needMap.keySet()) {
            if (!window.containsKey(key) || !needMap.get(key).equals(window.get(key))) {
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
        LeetCode567 leetCode567 = new LeetCode567();
        System.out.println(leetCode567.checkInclusion("ab", "eidbaooo"));
        System.out.println(leetCode567.checkInclusion("ab", "eidboaoo"));
    }
}
