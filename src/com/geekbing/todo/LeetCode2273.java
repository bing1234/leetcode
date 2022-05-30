package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author bing
 */
public class LeetCode2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String[] newWords = convertArr(words);
        int idx = 0, len = words.length;
        while (idx < len) {
            int i;
            for (i = idx + 1; i < len; i++) {
                if (!Objects.equals(newWords[idx], newWords[i])) {
                    break;
                }
            }
            ans.add(words[idx]);
            idx = i;
        }
        return ans;
    }

    private String[] convertArr(String[] words) {
        String[] ans = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = convertWord(words[i]);
        }
        return ans;
    }

    private String convertWord(String word) {
        int[] bucket = new int[26];
        char[] chars = word.toCharArray();
        for (char c : chars) {
            bucket[c - 'a']++;
        }
        String ans = "";
        for (int i = 0; i < 26; i++) {
            if (bucket[i] != 0) {
                ans += String.valueOf((char) ('a' + i)) + bucket[i];
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2273 leetCode2273 = new LeetCode2273();
        List<String> ans = leetCode2273.removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"});
        List<String> expert = new ArrayList<>(Arrays.asList("abba", "cd"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2273 leetCode2273 = new LeetCode2273();
        List<String> ans = leetCode2273.removeAnagrams(new String[]{"a", "b", "c", "d", "e"});
        List<String> expert = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        assert expert.equals(ans);
    }
}
