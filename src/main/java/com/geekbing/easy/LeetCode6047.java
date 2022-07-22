package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode6047 {
    public String removeDigit(String number, char digit) {
        int idx = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                idx = i;
                if (i + 1 < number.length() && number.charAt(idx) < number.charAt(idx + 1)) {
                    break;
                }
            }
        }
        return number.substring(0, idx) + number.substring(idx + 1);
    }

    @Test
    public void testCase1() {
        LeetCode6047 leetCode6047 = new LeetCode6047();
        String ans = leetCode6047.removeDigit("123", '3');
        assert ans.equals("12");
    }

    @Test
    public void testCase2() {
        LeetCode6047 leetCode6047 = new LeetCode6047();
        assert leetCode6047.removeDigit("1231", '1').equals("231");
    }

    @Test
    public void testCase3() {
        LeetCode6047 leetCode6047 = new LeetCode6047();
        assert leetCode6047.removeDigit("551", '5').equals("51");
    }
}
