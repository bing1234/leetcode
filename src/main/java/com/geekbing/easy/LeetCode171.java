package com.geekbing.easy;

public class LeetCode171 {
    public int titleToNumber(String s) {
        int ans = 0, base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += base * (s.charAt(i) - 'A' + 1);
            base *= 26;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode171 leetCode171 = new LeetCode171();
        System.out.println(leetCode171.titleToNumber("A"));
        System.out.println(leetCode171.titleToNumber("AB"));
        System.out.println(leetCode171.titleToNumber("ZY"));
    }
}
