package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * todo
 * @author bing
 */
public class LeetCode2125 {
    public int numberOfBeams(String[] bank) {
        return 0;
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
