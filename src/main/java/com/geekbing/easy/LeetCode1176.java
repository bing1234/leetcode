package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int ans = 0, sum = 0, left = 0, right = 0;
        while (right < calories.length) {
            if (right - left + 1 <= k) {
                sum += calories[right++];
            } else {
                if (sum < lower) {
                    ans--;
                } else if (sum > upper) {
                    ans++;
                }
                sum += calories[right++];
                sum -= calories[left++];
            }
        }
        if (sum < lower) {
            ans--;
        } else if (sum > upper) {
            ans++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1176 leetCode1176 = new LeetCode1176();
        assert leetCode1176.dietPlanPerformance(new int[]{1, 2, 3, 4, 5}, 1, 3, 3) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode1176 leetCode1176 = new LeetCode1176();
        assert leetCode1176.dietPlanPerformance(new int[]{3, 2}, 2, 0, 1) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1176 leetCode1176 = new LeetCode1176();
        assert leetCode1176.dietPlanPerformance(new int[]{6, 5, 0, 0}, 2, 1, 5) == 0;
    }
}
