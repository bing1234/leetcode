package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        // 特殊情况处理
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            // 剩下的是否一样
            if (same(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean same(String haystack, String needle, int index) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(index) != needle.charAt(i)) {
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode28 leetCode28 = new LeetCode28();
        System.out.println("".indexOf(""));
        System.out.println(leetCode28.strStr("hello", "ll"));
        System.out.println(leetCode28.strStr("aaaaa", "bba"));
    }
}
