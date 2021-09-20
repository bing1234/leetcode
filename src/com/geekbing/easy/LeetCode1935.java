package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        int ans = 0;
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                ans++;
            } else {
                if (set.contains(text.charAt(i))) {
                    while (i < text.length() && text.charAt(i) != ' ') {
                        i++;
                    }
                    if (i == text.length()) {
                        return ans;
                    }
                }
            }
            i++;
        }
        if (!set.contains(text.charAt(text.length() - 1))) {
            ans++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1935 leetCode1935 = new LeetCode1935();
        int ans = leetCode1935.canBeTypedWords("hello world", "ad");
        assert ans == 1;
    }

    @Test
    public void testCase2() {
        LeetCode1935 leetCode1935 = new LeetCode1935();
        int ans = leetCode1935.canBeTypedWords("leet code", "lt");
        assert ans == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1935 leetCode1935 = new LeetCode1935();
        int ans = leetCode1935.canBeTypedWords("leet code", "e");
        assert ans == 0;
    }

    @Test
    public void testCase4() {
        LeetCode1935 leetCode1935 = new LeetCode1935();
        int ans = leetCode1935.canBeTypedWords("jwssg", "cyvxmtjohsbpfqaur");
        assert ans == 0;
    }
}
