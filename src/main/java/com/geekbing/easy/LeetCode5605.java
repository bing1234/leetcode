package com.geekbing.easy;

public class LeetCode5605 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1 = 0, idx2 = 0, wordIdx1 = 0, wordIdx2 = 0;
        while (idx1 < word1.length && idx2 < word2.length) {
            while (wordIdx1 < word1[idx1].length() && wordIdx2 < word2[idx2].length()) {
                if (word1[idx1].charAt(wordIdx1) != word2[idx2].charAt(wordIdx2)) {
                    return false;
                }
                wordIdx1++;
                wordIdx2++;
            }
            if (wordIdx1 == word1[idx1].length()) {
                idx1++;
                wordIdx1 = 0;
            }
            if (wordIdx2 == word2[idx2].length()) {
                idx2++;
                wordIdx2 = 0;
            }
        }
        return idx1 == word1.length && idx2 == word2.length;
    }

    public static void main(String[] args) {
        LeetCode5605 leetCode5605 = new LeetCode5605();
        System.out.println(leetCode5605.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(leetCode5605.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        System.out.println(leetCode5605.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }
}
