package com.geekbing.easy;

/**
 * 521. 最长特殊序列 Ⅰ
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 *
 * @author bing
 */
public class LeetCode521 {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        }
        return a.equals(b) ? -1 : a.length();
    }

    public static void main(String[] args) {
        LeetCode521 leetCode521 = new LeetCode521();
        System.out.println(leetCode521.findLUSlength("aba", "cdc"));
        System.out.println(leetCode521.findLUSlength("aaa", "bbb"));
        System.out.println(leetCode521.findLUSlength("aaa", "aaa"));
    }
}
