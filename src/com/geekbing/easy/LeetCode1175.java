package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1175 {
    private static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        // 质数数量
        int primeCnt = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCnt++;
            }
        }
        // 非质数数量
        int noPrimeCnt = n - primeCnt;
        // 质数数量全排列 * 非质数数量全排列
        return (int) (factorial(primeCnt) * factorial(noPrimeCnt) % MOD);
    }

    private long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
            ans = ans % MOD;
        }
        return ans;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1175 leetCode1175 = new LeetCode1175();

        System.out.println(leetCode1175.numPrimeArrangements(5));
        System.out.println(leetCode1175.numPrimeArrangements(100));
    }
}
