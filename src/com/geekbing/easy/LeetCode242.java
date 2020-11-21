package com.geekbing.easy;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] s1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a']++;
            s1[t.charAt(i) - 'a']--;
        }
        for (int num : s1) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode242 leetCode242 = new LeetCode242();
        System.out.println(leetCode242.isAnagram("anagram", "nagaram"));
        System.out.println(leetCode242.isAnagram("rat", "car"));
    }
}
