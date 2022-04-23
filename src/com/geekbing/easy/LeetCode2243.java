package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2243 {
    public String digitSum(String s, int k) {
        while (s != null && s.length() > k) {
            s = converse(s, k);
        }
        return s;
    }

    private String converse(String str, int k) {
        StringBuilder ans = new StringBuilder();
        int idx = 0, len = str.length();
        while (idx < len) {
            int num = 0;
            for (int i = 0; i < k && idx < len; i++) {
                num = num + (str.charAt(idx++) - '0');
            }
            ans.append(num);
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode2243 leetCode2243 = new LeetCode2243();
        assert leetCode2243.digitSum("11111222223", 3).equals("135");
    }

    @Test
    public void testCase2() {
        LeetCode2243 leetCode2243 = new LeetCode2243();
        assert leetCode2243.digitSum("00000000", 3).equals("000");
    }
}
