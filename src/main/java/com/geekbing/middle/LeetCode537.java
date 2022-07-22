package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode537 {
    public String complexNumberMultiply(String num1, String num2) {
        int[] arr1 = parseComplexNumber(num1);
        int[] arr2 = parseComplexNumber(num2);
        int a = arr1[0] * arr2[0] - arr1[1] * arr2[1];
        int b = arr1[0] * arr2[1] + arr1[1] * arr2[0];
        return a + "+" + b + "i";
    }

    private int[] parseComplexNumber(String num) {
        String[] items = num.split("\\+");
        int a = Integer.parseInt(items[0]);
        int b = Integer.parseInt(items[1].substring(0, items[1].length() - 1));
        return new int[]{a, b};
    }

    @Test
    public void testCase1() {
        LeetCode537 leetCode537 = new LeetCode537();
        assert leetCode537.complexNumberMultiply("1+1i", "1+1i").equals("0+2i");
    }

    @Test
    public void testCase2() {
        LeetCode537 leetCode537 = new LeetCode537();
        assert leetCode537.complexNumberMultiply("1+-1i", "1+-1i").equals("0+-2i");
    }
}
