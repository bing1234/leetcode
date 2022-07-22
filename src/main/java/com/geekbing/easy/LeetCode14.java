package com.geekbing.easy;

public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs.length == 0) {
            return ans;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str : strs) {
                if (str.length() < i + 1 || str.charAt(i) != strs[0].charAt(i)) {
                    return ans;
                }
            }
            ans = ans + strs[0].charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode14 leetCode14 = new LeetCode14();
        System.out.println(leetCode14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(leetCode14.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
