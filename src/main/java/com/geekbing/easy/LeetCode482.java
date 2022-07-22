package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode482 {
    public String licenseKeyFormatting(String s, int k) {
        if (s == null || "".equals(s)) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                continue;
            }
            ans.insert(0, convert(chars[i]));
            cnt++;
            if (cnt == k) {
                ans.insert(0, '-');
                cnt = 0;
            }
        }
        if ("".equals(ans.toString())) {
            return ans.toString();
        }
        if (ans.charAt(0) == '-') {
            return ans.substring(1);
        }
        return ans.toString();
    }

    private char convert(char c) {
        if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z')) {
            return c;
        }
        return (char) (c - 32);
    }

    public static void main(String[] args) {
        LeetCode482 leetCode482 = new LeetCode482();
        System.out.println(leetCode482.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(leetCode482.licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(leetCode482.licenseKeyFormatting("---", 2));
    }
}
