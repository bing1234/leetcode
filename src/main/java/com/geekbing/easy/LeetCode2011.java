package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            switch (operation) {
                case "++X":
                case "X++":
                    ans++;
                    break;
                default:
                    ans--;
                    break;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2011 leetCode2011 = new LeetCode2011();
        int ans = leetCode2011.finalValueAfterOperations(new String[]{"--X", "X++", "X++"});
        assert ans == 1;
    }

    @Test
    public void testCase2() {
        LeetCode2011 leetCode2011 = new LeetCode2011();
        int ans = leetCode2011.finalValueAfterOperations(new String[]{"++X", "++X", "X++"});
        assert ans == 3;
    }

    @Test
    public void testCase3() {
        LeetCode2011 leetCode2011 = new LeetCode2011();
        int ans = leetCode2011.finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"});
        assert ans == 0;
    }
}
