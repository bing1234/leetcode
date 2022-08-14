package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0, true) ||
                isInterleave(s1, s2, s3, 0, 0, 0, false);
    }

    private boolean isInterleave(String s1, String s2, String s3,
                                 int idx1, int idx2, int idx3,
                                 boolean first) {
        if (idx1 == s1.length() && idx2 == s2.length() && idx3 == s3.length()) {
            return true;
        }
        if (first) {
            if (idx1 == s1.length()) {
                return false;
            }
            if (s1.charAt(idx1) != s3.charAt(idx3)) {
                return false;
            }
            return isInterleave(s1, s2, s3, idx1 + 1, idx2, idx3 + 1, true) ||
                    isInterleave(s1, s2, s3, idx1 + 1, idx2, idx3 + 1, false);
        } else {
            if (idx2 == s2.length()) {
                return false;
            }
            if (s2.charAt(idx2) != s3.charAt(idx3)) {
                return false;
            }
            return isInterleave(s1, s2, s3, idx1, idx2 + 1, idx3 + 1, true) ||
                    isInterleave(s1, s2, s3, idx1, idx2 + 1, idx3 + 1, false);
        }
    }

    @Test
    public void testCase1() {
        LeetCode97 leetCode97 = new LeetCode97();
        assert leetCode97.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    @Test
    public void testCase2() {
        LeetCode97 leetCode97 = new LeetCode97();
        assert !leetCode97.isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }

    @Test
    public void testCase3() {
        LeetCode97 leetCode97 = new LeetCode97();
        assert leetCode97.isInterleave("", "", "");
    }
}
