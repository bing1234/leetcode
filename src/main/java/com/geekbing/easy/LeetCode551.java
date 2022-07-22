package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode551 {
    public boolean checkRecord(String s) {
        boolean hasA = false;
        boolean preTwoIsL = false;
        boolean preOneIsL = false;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (hasA) {
                    return false;
                }
                hasA = true;
                preOneIsL = false;
            } else if (c == 'L') {
                if (preOneIsL && preTwoIsL) {
                    return false;
                }
                if (preOneIsL) {
                    preTwoIsL = true;
                }
                preOneIsL = true;
            } else {
                preOneIsL = false;
                preTwoIsL = false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode551 leetCode551 = new LeetCode551();
        assert leetCode551.checkRecord("PPALLP");
    }

    @Test
    public void testCase2() {
        LeetCode551 leetCode551 = new LeetCode551();
        assert !leetCode551.checkRecord("PPALLL");
    }
}
