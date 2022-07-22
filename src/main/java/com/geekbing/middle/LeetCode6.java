package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] lines = new String[numRows];
        Arrays.fill(lines, "");
        int curLine = 0;
        boolean asc = true;
        for (int i = 0; i < s.length(); i++) {
            lines[curLine] += s.charAt(i);
            if (curLine == 0) {
                curLine++;
                asc = true;
            } else if (curLine == numRows - 1) {
                curLine--;
                asc = false;
            } else {
                if (asc) {
                    curLine++;
                } else {
                    curLine--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String line : lines) {
            ans.append(line);
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode6 leetCode6 = new LeetCode6();
        assert leetCode6.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
    }

    @Test
    public void testCase2() {
        LeetCode6 leetCode6 = new LeetCode6();
        assert leetCode6.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
    }

    @Test
    public void testCase3() {
        LeetCode6 leetCode6 = new LeetCode6();
        assert leetCode6.convert("A", 1).equals("A");
    }
}
