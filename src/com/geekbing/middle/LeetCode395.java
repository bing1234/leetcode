package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        // 每个字符 - 出现的次数
        Map<Character, Integer> charCntMap = countChar(s);
        // 过滤出少于k次的字符
        Set<Character> lessChars = filterLessChars(charCntMap, k);
        // 出现次数都大于等于k次的话，则直接返回s
        if (lessChars.isEmpty()) {
            return s.length();
        }
        // 将字符串s按照小于k次的字符切分为一个个小段
        List<String> splits = splitByChars(s, lessChars);
        // 对每个小段递归求值取最大值即可
        int ans = 0;
        for (String split : splits) {
            ans = Math.max(ans, longestSubstring(split, k));
        }
        return ans;
    }

    private List<String> splitByChars(String s, Set<Character> lessChars) {
        List<String> splits = new ArrayList<>();
        StringBuilder split = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (lessChars.contains(c)) {
                if (split.length() != 0) {
                    splits.add(split.toString());
                }
                split = new StringBuilder();
            } else {
                split.append(c);
            }
        }
        if (split.length() != 0) {
            splits.add(split.toString());
        }
        return splits;
    }

    private Set<Character> filterLessChars(Map<Character, Integer> charCntMap, int k) {
        Set<Character> set = new HashSet<>();
        for (Character key : charCntMap.keySet()) {
            Integer cnt = charCntMap.get(key);
            if (cnt < k) {
                set.add(key);
            }
        }
        return set;
    }

    private Map<Character, Integer> countChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    @Test
    public void testCase1() {
        LeetCode395 leetCode395 = new LeetCode395();
        int ans = leetCode395.longestSubstring("aaabb", 3);
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode395 leetCode395 = new LeetCode395();
        int ans = leetCode395.longestSubstring("ababbc", 2);
        assert ans == 5;
    }

    @Test
    public void testCase3() {
        LeetCode395 leetCode395 = new LeetCode395();
        int ans = leetCode395.longestSubstring("ababa", 2);
        assert ans == 5;
    }

    @Test
    public void testCase4() {
        LeetCode395 leetCode395 = new LeetCode395();
        int ans = leetCode395.longestSubstring("ababc", 2);
        assert ans == 4;
    }

    @Test
    public void testCase5() {
        LeetCode395 leetCode395 = new LeetCode395();
        int ans = leetCode395.longestSubstring("abcab", 2);
        assert ans == 0;
    }

    @Test
    public void testCase6() {
        LeetCode395 leetCode395 = new LeetCode395();
        int ans = leetCode395.longestSubstring("abbcab", 2);
        assert ans == 2;
    }
}
