package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode820 {
    public int minimumLengthEncoding(String[] words) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode820 leetCode820 = new LeetCode820();
        assert leetCode820.minimumLengthEncoding(new String[]{"time", "me", "bell"}) == 10;
    }

    @Test
    public void testCase2() {
        LeetCode820 leetCode820 = new LeetCode820();
        assert leetCode820.minimumLengthEncoding(new String[]{"t"}) == 2;
    }
}
