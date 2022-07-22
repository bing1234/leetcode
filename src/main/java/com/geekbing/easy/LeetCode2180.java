package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2180 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            if (checkBitSumEven(i)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean checkBitSumEven(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }

    @Test
    public void testCase1() {
        LeetCode2180 leetCode2180 = new LeetCode2180();
        assert leetCode2180.countEven(4) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2180 leetCode2180 = new LeetCode2180();
        assert leetCode2180.countEven(30) == 14;
    }
}
