package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start, end;
        int i = 1;
        while (2 * k * i < chars.length) {
            start = 2 * k * (i - 1);
            end = start + k - 1;
            reverseWords(chars, start, end);
            i++;
        }
        int remainLen = chars.length - 2 * k * (i - 1);
        if (remainLen < k) {
            start = 2 * k * (i - 1);
            end = chars.length - 1;
        } else {
            start = 2 * k * (i - 1);
            end = start + k - 1;
        }
        reverseWords(chars, start, end);
        return new String(chars);
    }

    private void reverseWords(char[] chars, int start, int end) {
        while (start < end && end < chars.length) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LeetCode541 leetCode541 = new LeetCode541();
        System.out.println(leetCode541.reverseStr("a", 2));
        System.out.println(leetCode541.reverseStr("ab", 2));
        System.out.println(leetCode541.reverseStr("abc", 2));
        System.out.println(leetCode541.reverseStr("abcd", 2));
        System.out.println(leetCode541.reverseStr("abcde", 2));
        System.out.println(leetCode541.reverseStr("abcdef", 2));
        System.out.println(leetCode541.reverseStr("abcdefg", 2));
        System.out.println(leetCode541.reverseStr("abcdefgh", 2));
    }
}
