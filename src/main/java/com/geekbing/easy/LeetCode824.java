package com.geekbing.easy;

import java.util.Arrays;
import java.util.List;

public class LeetCode824 {
    private static final List<Character> VOWELS = Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

    public String toGoatLatin(String S) {
        StringBuilder ans = new StringBuilder();
        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            ans.append(convert(words[i], i + 1)).append(" ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    private String convert(String word, int idx) {
        StringBuilder ans;
        if (VOWELS.contains(word.charAt(0))) {
            ans = new StringBuilder(word + "ma");
        } else {
            ans = new StringBuilder(word.substring(1) + word.charAt(0) + "ma");
        }
        for (int i = 0; i < idx; i++){
            ans.append("a");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode824 leetCode824 = new LeetCode824();
        System.out.println(leetCode824.toGoatLatin("I speak Goat Latin"));
        System.out.println(leetCode824.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
