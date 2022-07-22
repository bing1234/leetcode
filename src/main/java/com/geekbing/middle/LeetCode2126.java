package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long cur = mass;
        for (int num : asteroids) {
            if (cur < num) {
                return false;
            }
            cur += num;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode2126 leetCode2126 = new LeetCode2126();
        assert leetCode2126.asteroidsDestroyed(10, new int[]{3, 9, 19, 5, 21});
    }

    @Test
    public void testCase2() {
        LeetCode2126 leetCode2126 = new LeetCode2126();
        assert !leetCode2126.asteroidsDestroyed(5, new int[]{4, 9, 23, 4});
    }
}
