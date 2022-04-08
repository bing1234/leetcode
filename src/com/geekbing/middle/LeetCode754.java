package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int i = 1, sum = 1;
        while (sum < target || (sum + target) % 2 != 0) {
            i++;
            sum += i;
        }
        return i;
    }

    @Test
    public void testCase1() {
        LeetCode754 leetCode754 = new LeetCode754();
        assert leetCode754.reachNumber(2) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode754 leetCode754 = new LeetCode754();
        assert leetCode754.reachNumber(3) == 2;
    }
}
