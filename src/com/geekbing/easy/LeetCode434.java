package com.geekbing.easy;

public class LeetCode434 {
    public int countSegments(String s) {
        int ans = 0;
        if (s == null || s.equals("")) {
            return ans;
        }
        boolean hasChar = false;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (hasChar) {
                    ans++;
                    hasChar = false;
                }
            } else {
                hasChar = true;
            }
        }
        return hasChar ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        LeetCode434 leetCode434 = new LeetCode434();
        System.out.println(leetCode434.countSegments("Hello, my name is John"));
        System.out.println(leetCode434.countSegments("                "));
        System.out.println(leetCode434.countSegments("         a       "));
    }
}
