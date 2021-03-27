package com.geekbing.easy;

public class LeetCode1796 {
    public int secondHighest(String s) {
        int max = -1, second = -1;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                int cur = c - '0';
                if (cur > max) {
                    second = max;
                    max = cur;
                } else if (cur == max) {
                    continue;
                } else if (cur > second) {
                    second = cur;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        LeetCode1796 leetCode1796 = new LeetCode1796();
        System.out.println(leetCode1796.secondHighest("dfa12321afd"));
        System.out.println(leetCode1796.secondHighest("abc1111"));
    }
}
