package com.geekbing.middle;

public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        // 剩余每个字符对应的数量
        int[] left = new int[26];
        for (char c : s.toCharArray()) {
            left[c - 'a']++;
        }

        // 包含的字符
        boolean[] remain = new boolean[26];

        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            left[c - 'a']--;
            if (remain[c - 'a']) {
                continue;
            }
            while (ans.length() > 0 && ans.charAt(ans.length() - 1) > c) {
                if (left[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                    remain[ans.charAt(ans.length() - 1) - 'a'] = false;
                    ans.deleteCharAt(ans.length() - 1);
                } else {
                    break;
                }
            }
            ans.append(c);
            remain[c - 'a'] = true;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode316 leetCode316 = new LeetCode316();
        System.out.println(leetCode316.removeDuplicateLetters("bcabc"));
        System.out.println(leetCode316.removeDuplicateLetters("cbacdcbc"));
    }
}
