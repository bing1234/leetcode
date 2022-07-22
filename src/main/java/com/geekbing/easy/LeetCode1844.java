package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1844 {
    public String replaceDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                ans.append(s.charAt(i));
            } else {
                ans.append((char) (s.charAt(i - 1) + s.charAt(i) - '0'));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode1844 solution1844 = new LeetCode1844();
        System.out.println(solution1844.replaceDigits("a1c1e1"));
        System.out.println(solution1844.replaceDigits("a1b2c3d4e"));
    }
}
