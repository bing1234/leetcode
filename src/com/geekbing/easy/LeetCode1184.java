package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        // 从0-start、0-destination、total
        int startSum = 0, destinationSum = 0, total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i < start) {
                startSum += distance[i];
            }
            if (i < destination) {
                destinationSum += distance[i];
            }
            total += distance[i];
        }
        int diff = Math.abs(destinationSum - startSum);
        return Math.min(diff, total - diff);
    }

    @Test
    public void testCase1() {
        LeetCode1184 leetCode1184 = new LeetCode1184();
        int ans = leetCode1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1);
        assert ans == 1;
    }

    @Test
    public void testCase2() {
        LeetCode1184 leetCode1184 = new LeetCode1184();
        int ans = leetCode1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2);
        assert ans == 3;
    }

    @Test
    public void testCase3() {
        LeetCode1184 leetCode1184 = new LeetCode1184();
        int ans = leetCode1184.distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3);
        assert ans == 4;
    }
}
