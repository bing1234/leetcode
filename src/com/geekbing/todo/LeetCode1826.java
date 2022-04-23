package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1826 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1826 leetCode1826 = new LeetCode1826();
        assert leetCode1826.badSensor(new int[]{2, 3, 4, 5}, new int[]{2, 1, 3, 4}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode1826 leetCode1826 = new LeetCode1826();
        assert leetCode1826.badSensor(new int[]{2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 5}) == -1;
    }

    @Test
    public void testCase3() {
        LeetCode1826 leetCode1826 = new LeetCode1826();
        assert leetCode1826.badSensor(new int[]{2, 3, 2, 2, 3, 2}, new int[]{2, 3, 2, 3, 2, 7}) == 2;
    }
}
