package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Lcp33 {
    public int storeWater(int[] bucket, int[] vat) {
        if (allZero(vat)) {
            return 0;
        }

        // 假设储水次数为p，求出可能的最大的储水次数
        int p = 0;
        for (int i = 0; i < vat.length; i++) {
            if (bucket[i] == 0) {
                p = Math.max(p, vat[i]);
            } else {
                p = Math.max(p, (vat[i] % bucket[i] == 0) ? vat[i] / bucket[i] : vat[i] / bucket[i] + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= p; i++) {
            ans = Math.min(ans, countOp(bucket, vat, i));
        }
        return ans;
    }

    private boolean allZero(int[] vat) {
        for (int v : vat) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    private int countOp(int[] bucket, int[] vat, int p) {
        // 储水p次
        int ans = p;
        for (int i = 0; i < vat.length; i++) {
            int v = vat[i] % p == 0 ? vat[i] / p : vat[i] / p + 1;
            if (bucket[i] < v) {
                ans += v - bucket[i];
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        Lcp33 lcp33 = new Lcp33();
        assert lcp33.storeWater(new int[]{1, 3}, new int[]{6, 8}) == 4;
    }

    @Test
    public void testCase2() {
        Lcp33 lcp33 = new Lcp33();
        assert lcp33.storeWater(new int[]{9, 0, 1}, new int[]{0, 2, 2}) == 3;
    }
}
