package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1196 {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int ans = 0, cur = 0;
        for (int num : weight) {
            if (cur + num > 5000) {
                return ans;
            }
            cur += num;
            ans++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1196 leetCode1196 = new LeetCode1196();
        assert leetCode1196.maxNumberOfApples(new int[]{100, 200, 150, 1000}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode1196 leetCode1196 = new LeetCode1196();
        assert leetCode1196.maxNumberOfApples(new int[]{900, 950, 800, 1000, 700, 800}) == 5;
    }
}
