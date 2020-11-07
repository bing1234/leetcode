package com.geekbing.easy;

public class LeetCode1160 {
    private int[] counts;

    public int countCharacters(String[] words, String chars) {
        counts = new int[26];
        for (char c : chars.toCharArray()) {
            counts[c - 'a']++;
        }
        int ans = 0;
        for (String word : words) {
            if (canSpell(word)) {
                ans += word.length();
            }
        }
        return ans;
    }

    private boolean canSpell(String word) {
        int[] curCounts = new int[26];
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (counts[idx] == 0) {
                return false;
            }
            curCounts[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] < curCounts[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1160 leetCode1160 = new LeetCode1160();
        System.out.println(leetCode1160.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(leetCode1160.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
