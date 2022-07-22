package com.geekbing.easy;

public class LeetCode1374 {
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            return geneWithChar('a', n - 1) + "b";
        } else {
            return geneWithChar('a', n);
        }
    }

    private String geneWithChar(char c, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode1374 leetCode1374 = new LeetCode1374();
        System.out.println(leetCode1374.generateTheString(4));
        System.out.println(leetCode1374.generateTheString(2));
        System.out.println(leetCode1374.generateTheString(7));
    }
}
