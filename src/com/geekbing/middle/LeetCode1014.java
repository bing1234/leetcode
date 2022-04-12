package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;

        // 从左到右
        int[] left = new int[len];
        left[0] = values[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], values[i] + i);
        }

        // 从右到左
        int[] right = new int[len];
        right[len - 1] = values[len - 1] - (len - 1);
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], values[i] - i);
        }

        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            ans = Math.max(ans, left[i] + right[i + 1]);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1014 leetCode1014 = new LeetCode1014();
        int ans = leetCode1014.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
        assert ans == 11;
    }

    @Test
    public void testCase2() {
        LeetCode1014 leetCode1014 = new LeetCode1014();
        assert leetCode1014.maxScoreSightseeingPair(new int[]{1, 2}) == 2;
    }
}
