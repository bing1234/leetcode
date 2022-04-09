package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        return new ArrayList<>();
    }

    @Test
    public void testCase1() {
        LeetCode89 leetCode89 = new LeetCode89();
        List<Integer> ans = leetCode89.grayCode(2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 1, 3, 2));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode89 leetCode89 = new LeetCode89();
        List<Integer> ans = leetCode89.grayCode(1);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 1));
        assert expert.equals(ans);
    }
}
