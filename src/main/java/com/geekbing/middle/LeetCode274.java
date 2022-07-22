package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations[citations.length - 1] == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > ans) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode274 leetCode274 = new LeetCode274();
        assert leetCode274.hIndex(new int[]{3, 0, 6, 1, 5}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode274 leetCode274 = new LeetCode274();
        assert leetCode274.hIndex(new int[]{1, 3, 1}) == 1;
    }
}
