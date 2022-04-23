package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2243 {
    public String digitSum(String s, int k) {
        return "";
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
