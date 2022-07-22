package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1486 {
    public int xorOperation(int n, int start) {
        if (n == 0) {
            return 0;
        }
        int result = start;
        for (int i = 1; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1486 leetCode1486 = new LeetCode1486();
        System.out.println(leetCode1486.xorOperation(5, 0));
        System.out.println(leetCode1486.xorOperation(4, 3));
        System.out.println(leetCode1486.xorOperation(1, 7));
        System.out.println(leetCode1486.xorOperation(10, 5));
    }
}
