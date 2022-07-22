package com.geekbing.easy;

public class LeetCode204 {
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n != i && n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode204 leetCode204 = new LeetCode204();
        System.out.println(leetCode204.countPrimes(2));
        System.out.println(leetCode204.countPrimes(10));
        System.out.println(leetCode204.countPrimes(0));
        System.out.println(leetCode204.countPrimes(1));
    }
}
