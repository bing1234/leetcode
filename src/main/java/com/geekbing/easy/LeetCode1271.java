package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1271 {
    private static final char[] BUCKET = new char[]{'O', 'I', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String toHexspeak(String num) {
        StringBuilder ans = new StringBuilder();
        long number = Long.parseLong(num);
        while (number > 0) {
            int cur = (int) (number % 16);
            if (2 <= cur && cur <= 9) {
                return "ERROR";
            }
            ans.insert(0, BUCKET[cur]);
            number /= 16;
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode1271 leetCode1271 = new LeetCode1271();
        String ans = leetCode1271.toHexspeak("257");
        assert ans.equals("IOI");
    }

    @Test
    public void testCase2() {
        LeetCode1271 leetCode1271 = new LeetCode1271();
        String ans = leetCode1271.toHexspeak("3");
        assert ans.equals("ERROR");
    }

    @Test
    public void testCase3() {
        LeetCode1271 leetCode1271 = new LeetCode1271();
        String ans = leetCode1271.toHexspeak("747823223228");
        assert ans.equals("AEIDBCDIBC");
    }
}
