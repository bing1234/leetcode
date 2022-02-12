package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode165 {
    public int compareVersion(String version1, String version2) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode165 leetCode165 = new LeetCode165();
        assert leetCode165.compareVersion("1.01", "1.001") == 0;
    }

    @Test
    public void testCase2() {
        LeetCode165 leetCode165 = new LeetCode165();
        assert leetCode165.compareVersion("1.0", "1.0.0") == 0;
    }

    @Test
    public void testCase3() {
        LeetCode165 leetCode165 = new LeetCode165();
        assert leetCode165.compareVersion("0.1", "1.1") == -1;
    }
}
