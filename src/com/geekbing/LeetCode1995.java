package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode1995 {
    public int countQuadruplets(int[] nums) {
        Map<Integer, List<Pair>> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                List<Pair> list = sumMap.getOrDefault(sum, new ArrayList<>());
                list.add(new Pair(i, j));
                sumMap.put(sum, list);
            }
        }
        Map<Integer, List<Pair>> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                List<Pair> list = diffMap.getOrDefault(diff, new ArrayList<>());
                list.add(new Pair(i, j));
                diffMap.put(diff, list);
            }
        }
        int ans = 0;
        for (Integer sum : sumMap.keySet()) {
            for (Pair sumPair : sumMap.get(sum)) {
                if (!diffMap.containsKey(sum)) {
                    continue;
                }
                for (Pair diffPair : diffMap.get(sum)) {
                    if (sumPair.j < diffPair.i) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private static class Pair {
        private final int i;
        private final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    @Test
    public void testCase1() {
        LeetCode1995 leetCode1995 = new LeetCode1995();
        assert leetCode1995.countQuadruplets(new int[]{1, 2, 3, 6}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode1995 leetCode1995 = new LeetCode1995();
        assert leetCode1995.countQuadruplets(new int[]{3, 3, 6, 4, 5}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode1995 leetCode1995 = new LeetCode1995();
        assert leetCode1995.countQuadruplets(new int[]{1, 1, 1, 3, 5}) == 4;
    }
}
