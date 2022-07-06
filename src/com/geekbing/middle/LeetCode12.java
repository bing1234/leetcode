package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode12 {
    private final int[] vals = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private final String[] strs = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int i = vals.length - 1;
        while (num > 0) {
            if (num >= vals[i]) {
                ans.append(strs[i]);
                num -= vals[i];
            } else {
                i--;
            }
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode12 leetCode12 = new LeetCode12();
        assert leetCode12.intToRoman(3).equals("III");
    }

    @Test
    public void testCase2() {
        LeetCode12 leetCode12 = new LeetCode12();
        assert leetCode12.intToRoman(4).equals("IV");
    }

    @Test
    public void testCase3() {
        LeetCode12 leetCode12 = new LeetCode12();
        assert leetCode12.intToRoman(9).equals("IX");
    }

    @Test
    public void testCase4() {
        LeetCode12 leetCode12 = new LeetCode12();
        assert leetCode12.intToRoman(58).equals("LVIII");
    }

    @Test
    public void testCase5() {
        LeetCode12 leetCode12 = new LeetCode12();
        String ans = leetCode12.intToRoman(1994);
        assert ans.equals("MCMXCIV");
    }

    @Test
    public void testCase6() {
        LeetCode12 leetCode12 = new LeetCode12();
        String ans = leetCode12.intToRoman(994);
        assert ans.equals("CMXCIV");
    }
}
