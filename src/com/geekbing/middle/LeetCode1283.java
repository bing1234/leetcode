package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Arrays.stream(nums).max().getAsInt();
        return binarySearch(nums, threshold, 1, max);
    }

    private int binarySearch(int[] nums, int threshold, int low, int high) {
        int ans = 0, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (valid(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean valid(int[] nums, int threshold, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += (num % mid == 0) ? num / mid : (num / mid + 1);
        }
        return sum <= threshold;
    }

    @Test
    public void testCase1() {
        LeetCode1283 leetCode1283 = new LeetCode1283();
        int ans = leetCode1283.smallestDivisor(new int[]{1, 2, 5, 9}, 6);
        assert ans == 5;
    }

    @Test
    public void testCase2() {
        LeetCode1283 leetCode1283 = new LeetCode1283();
        assert leetCode1283.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode1283 leetCode1283 = new LeetCode1283();
        assert leetCode1283.smallestDivisor(new int[]{19}, 5) == 4;
    }
}
