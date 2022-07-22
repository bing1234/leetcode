package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode275 {
    public int hIndex(int[] citations) {
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
        LeetCode275 leetCode275 = new LeetCode275();
        assert leetCode275.hIndex(new int[]{0, 1, 3, 5, 6}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode275 leetCode275 = new LeetCode275();
        assert leetCode275.hIndex(new int[]{1, 2, 100}) == 2;
    }
}
