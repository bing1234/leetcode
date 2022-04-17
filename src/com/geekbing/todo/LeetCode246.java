package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode246 {
    public boolean isStrobogrammatic(String num) {
        StringBuilder ans = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '6') {
                ans.append('9');
            } else if (c == '9') {
                ans.append('6');
            } else if (c == '0' || c == '1' || c == '8') {
                ans.append(c);
            } else {
                return false;
            }
        }
        return ans.toString().equals(num);
    }

    @Test
    public void testCase1() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert leetCode246.isStrobogrammatic("69");
    }

    @Test
    public void testCase2() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert leetCode246.isStrobogrammatic("88");
    }

    @Test
    public void testCase3() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert !leetCode246.isStrobogrammatic("962");
    }

    @Test
    public void testCase4() {
        LeetCode246 leetCode246 = new LeetCode246();
        assert leetCode246.isStrobogrammatic("1");
    }
}
