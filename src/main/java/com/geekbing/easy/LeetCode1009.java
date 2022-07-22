package com.geekbing.easy;

public class LeetCode1009 {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        return ((1 << bitLength(N)) - 1) ^ N;
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
        LeetCode1009 leetCode1009 = new LeetCode1009();
        System.out.println(leetCode1009.bitwiseComplement(5));
        System.out.println(leetCode1009.bitwiseComplement(7));
        System.out.println(leetCode1009.bitwiseComplement(10));
    }
}
