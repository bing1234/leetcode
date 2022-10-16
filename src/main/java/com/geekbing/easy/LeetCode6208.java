package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode6208 {
    public int countTime(String time) {
        int ans = 1;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            ans *= 24;
        } else if (time.charAt(0) == '?') {
            if (time.charAt(1) < '4') {
                ans *= 3;
            } else {
                ans *= 2;
            }
        } else if (time.charAt(1) == '?') {
            if (time.charAt(0) == '0' || time.charAt(0) == '1') {
                ans *= 10;
            } else {
                ans *= 4;
            }
        }
        if (time.charAt(3) == '?') {
            ans *= 6;
        }
        if (time.charAt(4) == '?') {
            ans *= 10;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6208 leetCode6208 = new LeetCode6208();
        int ans = leetCode6208.countTime("?5:00");
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode6208 leetCode6208 = new LeetCode6208();
        int ans = leetCode6208.countTime("0?:0?");
        assert ans == 100;
    }

    @Test
    public void testCase3() {
        LeetCode6208 leetCode6208 = new LeetCode6208();
        int ans = leetCode6208.countTime("??:??");
        assert ans == 1440;
    }
}