package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode720 {
    public String longestWord(String[] words) {
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        String ans = "";
        for (String word : words) {
            boolean flag = true;
            for (int i = 1; i <= word.length(); i++) {
                if (!set.contains(word.substring(0, i))) {
                    flag = false;
                    break;
                }
            }
            if (!flag || word.length() < ans.length()) {
                continue;
            }
            if (word.length() > ans.length()) {
                ans = word;
            } else {
                if (word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode720 leetCode720 = new LeetCode720();
        assert leetCode720.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}).equals("world");
    }

    @Test
    public void testCase2() {
        LeetCode720 leetCode720 = new LeetCode720();
        assert leetCode720.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}).equals("apple");
    }
}
