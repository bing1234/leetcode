package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1758 {
    public int minOperations(String s) {
        int firstIsZero = 0, firstIsOne = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] == '0') {
                    firstIsOne++;
                } else {
                    firstIsZero++;
                }
            } else {
                if (arr[i] == '0') {
                    firstIsZero++;
                } else {
                    firstIsOne++;
                }
            }
        }
        return Math.min(firstIsZero, firstIsOne);
    }

    public static void main(String[] args) {
        LeetCode1758 leetCode1758 = new LeetCode1758();
        System.out.println(leetCode1758.minOperations("0100"));
        System.out.println(leetCode1758.minOperations("10"));
        System.out.println(leetCode1758.minOperations("1111"));
    }
}
