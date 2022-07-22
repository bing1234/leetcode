package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2125 {
    public int numberOfBeams(String[] bank) {
        int ans = 0, preNum = 0;
        for (String str : bank) {
            int count = countOfOne(str);
            if (count != 0) {
                if (preNum == 0) {
                    preNum = count;
                } else {
                    ans += preNum * count;
                    preNum = count;
                }
            }
        }
        return ans;
    }

    private int countOfOne(String str) {
        int ans = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2125 leetCode2125 = new LeetCode2125();
        assert leetCode2125.numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}) == 8;
    }

    @Test
    public void testCase2() {
        LeetCode2125 leetCode2125 = new LeetCode2125();
        assert leetCode2125.numberOfBeams(new String[]{"000", "111", "000"}) == 0;
    }
}
