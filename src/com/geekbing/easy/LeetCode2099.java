package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author bing
 */
public class LeetCode2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        return IntStream.range(0, nums.length)
                .mapToObj(i -> new Pair(i, nums[i]))
                .sorted((o1, o2) -> Integer.compare(o2.num, o1.num))
                .limit(k)
                .sorted(Comparator.comparingInt(o -> o.index))
                .map(p -> p.num)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static class Pair {
        private final int index;
        private final int num;

        public Pair(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2099 leetCode2099 = new LeetCode2099();
        int[] ans = leetCode2099.maxSubsequence(new int[]{2, 1, 3, 3}, 2);
        int[] expert = new int[]{3, 3};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2099 leetCode2099 = new LeetCode2099();
        int[] ans = leetCode2099.maxSubsequence(new int[]{-1, -2, 3, 4}, 3);
        int[] expert = new int[]{-1, 3, 4};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase3() {
        LeetCode2099 leetCode2099 = new LeetCode2099();
        int[] ans = leetCode2099.maxSubsequence(new int[]{3, 4, 3, 3}, 2);
        int[] expert = new int[]{3, 4};
        assert Arrays.equals(expert, ans);
    }
}
