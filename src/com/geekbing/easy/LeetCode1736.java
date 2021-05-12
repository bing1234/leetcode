package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1736 {
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        String ans = "";
        if (chars[0] == '?' && chars[1] == '?') {
            ans += "23";
        } else if (chars[0] == '?') {
            if (chars[1] <= '3') {
                ans += "2";
            } else {
                ans += "1";
            }
            ans += chars[1];
        } else if (chars[1] == '?') {
            ans += chars[0];
            if (chars[0] <= '1') {
                ans += "9";
            } else {
                ans += "3";
            }
        } else {
            ans += String.valueOf(chars[0]) + String.valueOf(chars[1]);
        }
        ans += ":";
        if (chars[3] == '?' && chars[4] == '?') {
            ans += "59";
        } else if (chars[3] == '?') {
            ans += "5";
            ans += chars[4];
        } else if (chars[4] == '?') {
            ans += chars[3];
            ans += "9";
        } else {
            ans += String.valueOf(chars[3]) + String.valueOf(chars[4]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1736 leetCode1736 = new LeetCode1736();
        System.out.println(leetCode1736.maximumTime("2?:?0"));
        System.out.println(leetCode1736.maximumTime("0?:3?"));
        System.out.println(leetCode1736.maximumTime("1?:22"));
    }
}
