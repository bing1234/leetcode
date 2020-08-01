package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode389 {
    public char findTheDifference(String s, String t) {
        // 所有字符进行亦或操作，最后就是多出来的字符
        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i) ^ t.charAt(i);
        }
        result ^= t.charAt(s.length());
        return result;
    }

    public char findTheDifferenceV2(String s, String t) {
        // 所有字符进行亦或操作，最后就是多出来的字符
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode389 leetCode389 = new LeetCode389();
        System.out.println(leetCode389.findTheDifferenceV2("abcd", "abcde"));
    }
}
