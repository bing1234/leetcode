package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1228 {
    public int missingNumber(int[] arr) {
        // (头 + 尾) * 长度 / 2 - 数组和
        return (arr[0] + arr[arr.length - 1]) * (arr.length + 1) / 2 - Arrays.stream(arr).sum();
    }

    @Test
    public void testCase1() {
        LeetCode1228 leetCode1228 = new LeetCode1228();
        assert leetCode1228.missingNumber(new int[]{5, 7, 11, 13}) == 9;
    }

    @Test
    public void testCase2() {
        LeetCode1228 leetCode1228 = new LeetCode1228();
        assert leetCode1228.missingNumber(new int[]{15, 13, 12}) == 14;
    }
}
