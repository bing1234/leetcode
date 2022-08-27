package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2379 {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, right = k - 1;
        int temp = 0;
        for (int i = left; i <= right; i++) {
            if (blocks.charAt(i) == 'W') {
                temp++;
            }
        }
        if (temp == 0) {
            return 0;
        }
        int ans = temp;
        while (right + 1 < blocks.length()) {
            if (blocks.charAt(left) == 'W' && blocks.charAt(right + 1) == 'B') {
                temp -= 1;
            } else if (blocks.charAt(left) == 'B' && blocks.charAt(right + 1) == 'W') {
                temp += 1;
            }
            ans = Math.min(ans, temp);
            if (ans == 0) {
                return ans;
            }
            left++;
            right++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2379 leetCode2379 = new LeetCode2379();
        int ans = leetCode2379.minimumRecolors("WBBWWBBWBW", 7);
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2379 leetCode2379 = new LeetCode2379();
        int ans = leetCode2379.minimumRecolors("WBWBBBW", 2);
        assert ans == 0;
    }
}
