package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode2078 {
    public int maxDistance(int[] colors) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            Pair pair = map.getOrDefault(colors[i], new Pair(i, i));
            pair.right = i;
            map.put(colors[i], pair);
        }

        int ans = 0;
        for (Pair pairA : map.values()) {
            for (Pair pairB : map.values()) {
                if (pairA != pairB) {
                    ans = Math.max(ans, Math.abs(pairA.right - pairB.left));
                    ans = Math.max(ans, Math.abs(pairB.right - pairA.left));
                }
            }
        }
        return ans;
    }

    private static class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2078 leetCode2078 = new LeetCode2078();
        int ans = leetCode2078.maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1});
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2078 leetCode2078 = new LeetCode2078();
        int ans = leetCode2078.maxDistance(new int[]{1, 8, 3, 8, 3});
        assert ans == 4;
    }

    @Test
    public void testCase3() {
        LeetCode2078 leetCode2078 = new LeetCode2078();
        int ans = leetCode2078.maxDistance(new int[]{0, 1});
        assert ans == 1;
    }
}
