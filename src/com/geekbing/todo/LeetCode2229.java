package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2229 {
    public boolean isConsecutive(int[] nums) {
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode2229 leetCode2229 = new LeetCode2229();
        assert leetCode2229.isConsecutive(new int[]{1, 3, 4, 2});
    }

    @Test
    public void testCase2() {
        LeetCode2229 leetCode2229 = new LeetCode2229();
        assert !leetCode2229.isConsecutive(new int[]{1, 3});
    }

    @Test
    public void testCase3() {
        LeetCode2229 leetCode2229 = new LeetCode2229();
        assert leetCode2229.isConsecutive(new int[]{3, 5, 4});
    }
}
