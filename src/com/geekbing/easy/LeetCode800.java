package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode800 {
    private static final int[] ARR = new int[]{0, 17, 34, 51, 68, 85, 102, 119, 136, 153, 170, 187, 204, 221, 238, 255};
    private static final String[] SUB = new String[]{"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};

    public String similarRGB(String color) {
        return "#" + similar(color.substring(1, 3)) + similar(color.substring(3, 5)) + similar(color.substring(5, 7));
    }

    private String similar(String str) {
        if (str.charAt(0) == str.charAt(1)) {
            return str;
        }
        int number = 16 * hexToTen(str.charAt(0)) + hexToTen(str.charAt(1));
        int minDiff = Integer.MAX_VALUE, minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < ARR.length; i++) {
            int diff = Math.abs(ARR[i] - number);
            if (diff < minDiff) {
                minDiff = diff;
                minIdx = i;
            }
        }
        return SUB[minIdx];
    }

    private int hexToTen(char c) {
        if (Character.isDigit(c)) {
            return c - '0';
        }
        return c - 'a' + 10;
    }

    @Test
    public void testCase() {
        for (int i = 0; i <= 16; i++) {
            int num = i * 16 + i;
            System.out.print(num + ",");
        }
    }

    @Test
    public void testCase1() {
        LeetCode800 leetCode800 = new LeetCode800();
        String ans = leetCode800.similarRGB("#09f166");
        assert ans.equals("#11ee66");
    }

    @Test
    public void testCase2() {
        LeetCode800 leetCode800 = new LeetCode800();
        String ans = leetCode800.similarRGB("#4e3fe1");
        assert ans.equals("#5544dd");
    }
}
