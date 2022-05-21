package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < position.length; i++) {
            min = Math.min(min, position[i] - position[i - 1]);
        }
        return binarySearch(position, m, min, position[position.length - 1] - position[0]);
    }

    private int binarySearch(int[] position, int m, int low, int high) {
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (valid(position, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean valid(int[] position, int m, int subDistance) {
        int pre = position[0], count = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= subDistance) {
                pre = position[i];
                count++;
            }
        }
        return count >= m;
    }

    @Test
    public void testCase1() {
        LeetCode1552 leetCode1552 = new LeetCode1552();
        int ans = leetCode1552.maxDistance(new int[]{1, 2, 3, 4, 7}, 3);
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1552 leetCode1552 = new LeetCode1552();
        assert leetCode1552.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2) == 999999999;
    }
}
