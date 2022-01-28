package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1957 {
    public String makeFancyString(String s) {


        return "";
    }

    @Test
    public void testCase1() {
        LeetCode1957 leetCode1957 = new LeetCode1957();
        assert leetCode1957.makeFancyString("leeetcode").equals("leetcode");
    }

    @Test
    public void testCase2() {
        LeetCode1957 leetCode1957 = new LeetCode1957();
        assert leetCode1957.makeFancyString("aaabaaaa").equals("aaabaaaa");
    }

    @Test
    public void testCase3() {
        LeetCode1957 leetCode1957 = new LeetCode1957();
        assert leetCode1957.makeFancyString("aab").equals("aab");
    }
}
