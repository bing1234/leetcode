package com.geekbing.easy;

public class LeetCode387 {
    public int firstUniqChar(String s) {
        int[] bucket = new int[26];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (bucket[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode387 leetCode387 = new LeetCode387();
        System.out.println(leetCode387.firstUniqChar("leetcode"));
        System.out.println(leetCode387.firstUniqChar("loveleetcode"));
    }
}
