package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1876 {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] != chars[i + 1] && chars[i + 1] != chars[i + 2] && chars[i] != chars[i + 2]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1876 leetCode1876 = new LeetCode1876();
        System.out.println(leetCode1876.countGoodSubstrings("xyzzaz"));
        System.out.println(leetCode1876.countGoodSubstrings("aababcabc"));
    }
}
