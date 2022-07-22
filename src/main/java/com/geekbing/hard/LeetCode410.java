package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode410 {
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        return binary(nums, m, max, sum);
    }

    private int binary(int[] nums, int m, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (valid(nums, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean valid(int[] nums, int m, int subSum) {
        int sum = 0, count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > subSum) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode410 leetCode410 = new LeetCode410();
        assert leetCode410.splitArray(new int[]{7, 2, 5, 10, 8}, 2) == 18;
    }

    @Test
    public void testCase2() {
        LeetCode410 leetCode410 = new LeetCode410();
        assert leetCode410.splitArray(new int[]{1, 2, 3, 4, 5}, 2) == 9;
    }

    @Test
    public void testCase3() {
        LeetCode410 leetCode410 = new LeetCode410();
        assert leetCode410.splitArray(new int[]{1, 4, 4}, 3) == 4;
    }
}
