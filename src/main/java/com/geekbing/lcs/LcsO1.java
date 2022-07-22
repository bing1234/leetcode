package com.geekbing.lcs;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LcsO1 {
    public int leastMinutes(int n) {
        int ans = 0;
        // 当前带宽量
        int cur = 1;
        while (true) {
            if (n <= cur) {
                ans++;
                break;
            } else {
                cur *= 2;
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LcsO1 lcsO1 = new LcsO1();
        assert lcsO1.leastMinutes(2) == 2;
    }

    @Test
    public void testCase2() {
        LcsO1 lcsO1 = new LcsO1();
        assert lcsO1.leastMinutes(4) == 3;
    }
}
