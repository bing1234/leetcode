package com.geekbing.lcp;

/**
 * @author bing
 */
public class LCP22 {
    public int paintingPlan(int n, int k) {
        // 不涂或涂满都只有1总方案
        if (k == 0 || n * n == k) {
            return 1;
        }
        if (k < n) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if ((i + j) * n - i * j == k) {
                    ans += C(i, n) * C(j, n);
                }
            }
        }
        return ans;
    }

    private int C(int m, int n) {
        return factorial(n) / factorial(m) / factorial(n - m);
    }

    private int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        LCP22 lcp22 = new LCP22();
        System.out.println(lcp22.paintingPlan(2, 2));
        System.out.println(lcp22.paintingPlan(2, 1));
        System.out.println(lcp22.paintingPlan(2, 4));
    }
}
