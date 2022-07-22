package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode8 {
    public int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        long ans = 0;
        int i = 0, base = 10;
        // 去掉前导空格
        while (i < s.length() && chars[i] == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        if (chars[i] != '-' && chars[i] != '+' && (chars[i] < '0' || chars[i] > '9')) {
            return 0;
        }
        boolean negative = false;
        if (chars[i] == '+') {
            i++;
        } else if (chars[i] == '-') {
            negative = true;
            i++;
        }
        while (i < s.length() && '0' <= chars[i] && chars[i] <= '9') {
            ans = ans * base + chars[i] - '0';
            if (negative && -ans <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!negative && ans >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return negative ? (int) -ans : (int) ans;
    }

    public static void main(String[] args) {
        LeetCode8 leetCode8 = new LeetCode8();

//        System.out.println(leetCode8.myAtoi("+1"));
//        System.out.println(leetCode8.myAtoi(" "));
//        System.out.println(leetCode8.myAtoi("-0"));
//        System.out.println(leetCode8.myAtoi("42"));
//        System.out.println(leetCode8.myAtoi("   -42"));
//        System.out.println(leetCode8.myAtoi("4193 with words"));
//        System.out.println(leetCode8.myAtoi("words and 987"));
//        System.out.println(leetCode8.myAtoi("-91283472332"));

        System.out.println(leetCode8.myAtoi("-2147483647"));

    }
}
