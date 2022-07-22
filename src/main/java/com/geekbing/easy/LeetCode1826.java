package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1826 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        // 找到第一个不相等的下标
        int diffIdx = -1;
        for (int i = 0; i < sensor1.length; i++) {
            if (sensor1[i] != sensor2[i]) {
                diffIdx = i;
                break;
            }
        }
        // 如果全部都相等，或是最后一个数字不相等
        if (diffIdx == -1 || diffIdx == sensor1.length - 1) {
            return -1;
        }
        // 假如第一个坏了
        boolean first = true;
        for (int i = diffIdx; i < sensor1.length - 1; i++) {
            if (sensor1[i] != sensor2[i + 1]) {
                first = false;
                break;
            }
        }
        // 假如第二个坏了
        boolean second = true;
        for (int i = diffIdx; i < sensor1.length - 1; i++) {
            if (sensor2[i] != sensor1[i + 1]) {
                second = false;
                break;
            }
        }
        if (first && !second) {
            return 1;
        }
        if (!first && second) {
            return 2;
        }
        return -1;
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

    @Test
    public void testCase4() {
        LeetCode1826 leetCode1826 = new LeetCode1826();
        assert leetCode1826.badSensor(new int[]{1, 2, 3, 2, 3, 2}, new int[]{1, 2, 3, 3, 2, 3}) == -1;
    }
}
