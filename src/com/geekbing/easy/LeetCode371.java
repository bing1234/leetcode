package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode371 {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        // 低位
        int lower = a ^ b;
        // 进位
        int carry = a & b;
        if (carry == 0) {
            return lower;
        }
        return getSum(lower, carry << 1);
    }

    public static void main(String[] args) {
        LeetCode371 leetCode371 = new LeetCode371();
        System.out.println(leetCode371.getSum(1, 2));
        System.out.println(leetCode371.getSum(-2, 3));
        System.out.println(leetCode371.getSum(-1, 1));
    }
}
