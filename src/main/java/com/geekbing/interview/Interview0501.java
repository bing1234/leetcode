package com.geekbing.interview;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Interview0501 {
    public int insertBits(int N, int M, int i, int j) {
        // 将N的第[i-j]位置为0
        for (int temp = i; temp <= j; temp++) {
            N &= ~(1 << temp);
        }
        // 将M左移动i位后与N做或运算
        return (M << i) | N;
    }

    @Test
    public void test() {
        System.out.println(1 << 2);
    }

    @Test
    public void testCase1() {
        Interview0501 interview0501 = new Interview0501();
        assert interview0501.insertBits(1024, 19, 2, 6) == 1100;
    }

    @Test
    public void testCase2() {
        Interview0501 interview0501 = new Interview0501();
        assert interview0501.insertBits(0, 31, 0, 4) == 31;
    }

    @Test
    public void testCase3() {
        Interview0501 interview0501 = new Interview0501();
        assert interview0501.insertBits(2032243561, 10, 24, 29) == 1243714409;
    }
}
