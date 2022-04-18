package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode266 {
    public boolean canPermutePalindrome(String s) {
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        int cnt = 0;
        for (int num : bucket) {
            if (num % 2 == 1) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode266 leetCode266 = new LeetCode266();
        assert !leetCode266.canPermutePalindrome("code");
    }

    @Test
    public void testCase2() {
        LeetCode266 leetCode266 = new LeetCode266();
        assert leetCode266.canPermutePalindrome("aab");
    }

    @Test
    public void testCase3() {
        LeetCode266 leetCode266 = new LeetCode266();
        assert leetCode266.canPermutePalindrome("carerac");
    }
}
