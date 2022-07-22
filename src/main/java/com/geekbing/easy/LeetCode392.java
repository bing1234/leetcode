package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        int indexS = 0, indexT = 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
            indexT++;
        }
        return indexS == s.length();
    }

    public static void main(String[] args) {
        LeetCode392 leetCode392 = new LeetCode392();
        System.out.println(leetCode392.isSubsequence("abc", "ahbgdc"));
        System.out.println(leetCode392.isSubsequence("axc", "ahbgdc"));
    }
}
