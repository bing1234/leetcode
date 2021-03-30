package com.geekbing.easy;

public class LeetCode693 {
    public boolean hasAlternatingBits(int n) {
        Integer pre = null, cur;
        while (n > 0) {
            if (pre == null) {
                pre = n % 2;
            } else {
                cur = n % 2;
                if (pre + cur != 1) {
                    return false;
                }
                pre = cur;
            }
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode693 leetCode693 = new LeetCode693();
        System.out.println(leetCode693.hasAlternatingBits(5));
        System.out.println(leetCode693.hasAlternatingBits(7));
        System.out.println(leetCode693.hasAlternatingBits(11));
        System.out.println(leetCode693.hasAlternatingBits(10));
        System.out.println(leetCode693.hasAlternatingBits(3));
    }
}
