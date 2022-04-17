package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum / 4, cnt = 0;
        for (int num : matchsticks) {
            if (num > len) {
                return false;
            } else if (num == len) {
                cnt++;
            }
        }
        if (cnt == 4) {
            return true;
        }
        
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode473 leetCode473 = new LeetCode473();
        assert leetCode473.makesquare(new int[]{1, 1, 2, 2, 2});
    }

    @Test
    public void testCase2() {
        LeetCode473 leetCode473 = new LeetCode473();
        assert !leetCode473.makesquare(new int[]{3, 3, 3, 3, 4});
    }
}
