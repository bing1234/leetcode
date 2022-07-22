package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || "".equals(ransomNote)) {
            return true;
        }
        int[] bucket = new int[26];
        for (char c : ransomNote.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if (bucket[c - 'a'] > 0) {
                bucket[c - 'a']--;
            }
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += bucket[i];
            }
            if (sum == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode383 leetCode383 = new LeetCode383();
        System.out.println(leetCode383.canConstruct("a", "b"));
        System.out.println(leetCode383.canConstruct("aa", "ab"));
        System.out.println(leetCode383.canConstruct("aa", "aab"));
        System.out.println(leetCode383.canConstruct("aab", "baa"));
    }
}
