package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int left = 0, right = words.length - 1;
        while (left < right) {
            while (left < right && words[left].equals("")) {
                left++;
            }
            while (left < right && words[right].equals("")) {
                right--;
            }
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            ans.append(word).append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }

    @Test
    public void testCase1() {
        LeetCode151 leetCode151 = new LeetCode151();
        assert leetCode151.reverseWords("the sky is blue").equals("blue is sky the");
    }

    @Test
    public void testCase2() {
        LeetCode151 leetCode151 = new LeetCode151();
        assert leetCode151.reverseWords("  hello world  ").equals("world hello");
    }

    @Test
    public void testCase3() {
        LeetCode151 leetCode151 = new LeetCode151();
        assert leetCode151.reverseWords("a good   example").equals("example good a");
    }

    @Test
    public void testCase4() {
        LeetCode151 leetCode151 = new LeetCode151();
        assert leetCode151.reverseWords("  Bob    Loves  Alice   ").equals("Alice Loves Bob");
    }

    @Test
    public void testCase5() {
        LeetCode151 leetCode151 = new LeetCode151();
        assert leetCode151.reverseWords("Alice does not even like bob").equals("bob like even not does Alice");
    }
}
