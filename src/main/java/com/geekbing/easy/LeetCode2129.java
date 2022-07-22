package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2129 {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(convert(word)).append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }

    private String convert(String word) {
        String lower = word.toLowerCase();
        if (lower.length() <= 2) {
            return lower;
        }
        return (char) (lower.charAt(0) - 32) + lower.substring(1);
    }

    @Test
    public void testCase1() {
        LeetCode2129 leetCode2129 = new LeetCode2129();
        assert leetCode2129.capitalizeTitle("capiTalIze tHe titLe").equals("Capitalize The Title");
    }

    @Test
    public void testCase2() {
        LeetCode2129 leetCode2129 = new LeetCode2129();
        assert leetCode2129.capitalizeTitle("First leTTeR of EACH Word").equals("First Letter of Each Word");
    }

    @Test
    public void testCase3() {
        LeetCode2129 leetCode2129 = new LeetCode2129();
        assert leetCode2129.capitalizeTitle("i lOve leetcode").equals("i Love Leetcode");
    }
}
