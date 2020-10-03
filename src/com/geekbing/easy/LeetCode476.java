package com.geekbing.easy;

public class LeetCode476 {
    public int findComplement(int num) {
        return ((1 << bitLength(num)) - 1) ^ num;
    }

    private int bitLength(int num) {
        int ans = 0;
        while (num > 0) {
            num = num >> 1;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode476 leetCode476 = new LeetCode476();
        System.out.println(leetCode476.findComplement(2147483647));
        System.out.println(leetCode476.findComplement(5));
        System.out.println(leetCode476.findComplement(1));
    }
}
