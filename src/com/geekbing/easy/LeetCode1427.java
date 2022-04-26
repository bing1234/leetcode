package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1427 {
    public String stringShift(String s, int[][] shift) {
        int amount = 0;
        for (int[] arr : shift) {
            if (arr[0] == 0) {
                amount += arr[1];
            } else {
                amount -= arr[1];
            }
        }
        if (amount == 0) {
            return s;
        }
        if (amount > 0) {
            amount = amount % s.length();
            return s.substring(amount) + s.substring(0, amount);
        }
        amount = Math.abs(amount) % s.length();
        return s.substring(s.length() - amount) + s.substring(0, s.length() - amount);
    }

    @Test
    public void testCase1() {
        LeetCode1427 leetCode1427 = new LeetCode1427();
        String ans = leetCode1427.stringShift("abc", new int[][]{{0, 1}, {1, 2}});
        assert ans.equals("cab");
    }

    @Test
    public void testCase2() {
        LeetCode1427 leetCode1427 = new LeetCode1427();
        String ans = leetCode1427.stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}});
        assert ans.equals("efgabcd");
    }

    @Test
    public void testCase3() {
        LeetCode1427 leetCode1427 = new LeetCode1427();
        String ans = leetCode1427.stringShift("mecsk", new int[][]{{1, 4}, {0, 5}, {0, 4}, {1, 1}, {1, 5}});
        assert ans.equals("kmecs");
    }
}
