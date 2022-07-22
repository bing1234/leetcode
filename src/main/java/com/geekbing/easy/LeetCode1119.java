package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode1119 {
    private final Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public String removeVowels(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode1119 leetCode1119 = new LeetCode1119();
        assert leetCode1119.removeVowels("leetcodeisacommunityforcoders").equals("ltcdscmmntyfrcdrs");
    }

    @Test
    public void testCase2() {
        LeetCode1119 leetCode1119 = new LeetCode1119();
        assert leetCode1119.removeVowels("aeiou").equals("");
    }
}
