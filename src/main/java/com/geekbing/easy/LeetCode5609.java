package com.geekbing.easy;

public class LeetCode5609 {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] chars = new int[26];
        for (char c : allowed.toCharArray()) {
            chars[c - 'a'] = 1;
        }
        int ans = 0;
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (chars[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode5609 leetCode5609 = new LeetCode5609();
        System.out.println(leetCode5609.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(leetCode5609.countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(leetCode5609.countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }
}
