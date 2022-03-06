package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        return new ArrayList<>();
    }

    @Test
    public void testCase1() {
        LeetCode2100 leetCode2100 = new LeetCode2100();
        List<Integer> ans = leetCode2100.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(2, 3));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2100 leetCode2100 = new LeetCode2100();
        List<Integer> ans = leetCode2100.goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode2100 leetCode2100 = new LeetCode2100();
        List<Integer> ans = leetCode2100.goodDaysToRobBank(new int[]{1, 2, 3, 4, 5, 6}, 2);
        assert new ArrayList<>().equals(ans);
    }

    @Test
    public void testCase4() {
        LeetCode2100 leetCode2100 = new LeetCode2100();
        List<Integer> ans = leetCode2100.goodDaysToRobBank(new int[]{1}, 5);
        assert new ArrayList<>().equals(ans);
    }
}
