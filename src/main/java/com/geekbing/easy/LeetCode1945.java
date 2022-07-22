package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1945 {
    public int getLucky(String s, int k) {
        // 将s转化为一个整数
        String num = transform(s);

        // 将整数转换为其各位数字之和。共重复转换操作k次
        return conversion(num, k);
    }

    private String transform(String s) {
        StringBuilder num = new StringBuilder();
        for (char c : s.toCharArray()) {
            num.append(c - 'a' + 1);
        }
        return num.toString();
    }

    private int conversion(String num, int k) {
        if ("0".equals(num) || "1".equals(num)) {
            return Integer.parseInt(num);
        }
        for (int i = 0; i < k; i++) {
            num = conversion(num);
        }
        return Integer.parseInt(num);
    }

    private String conversion(String num) {
        int res = 0;
        for (char c : num.toCharArray()) {
            res += (c - '0');
        }
        return String.valueOf(res);
    }

    @Test
    public void testCase1() {
        LeetCode1945 leetCode1945 = new LeetCode1945();
        assert leetCode1945.getLucky("iiii", 1) == 36;
    }

    @Test
    public void testCase2() {
        LeetCode1945 leetCode1945 = new LeetCode1945();
        assert leetCode1945.getLucky("leetcode", 2) == 6;
    }
}
