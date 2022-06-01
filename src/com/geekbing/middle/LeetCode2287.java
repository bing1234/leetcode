package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] sourceBucket = new int[26];
        int[] targetBucket = new int[26];
        for (char c : s.toCharArray()) {
            sourceBucket[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            targetBucket[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (targetBucket[i] > 0) {
                ans = Math.min(ans, sourceBucket[i] / targetBucket[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    @Test
    public void testCase1() {
        LeetCode2287 leetCode2287 = new LeetCode2287();
        assert leetCode2287.rearrangeCharacters("ilovecodingonleetcode", "code") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2287 leetCode2287 = new LeetCode2287();
        assert leetCode2287.rearrangeCharacters("abcba", "abc") == 1;
    }

    @Test
    public void testCase3() {
        LeetCode2287 leetCode2287 = new LeetCode2287();
        assert leetCode2287.rearrangeCharacters("abbaccaddaeea", "aaaaa") == 1;
    }
}
