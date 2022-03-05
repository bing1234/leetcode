package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum = (sum * 2 + num) % 10;
            ans.add(sum % 5 == 0);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1018 leetCode1018 = new LeetCode1018();
        List<Boolean> ans = leetCode1018.prefixesDivBy5(new int[]{0, 1, 1});
        List<Boolean> expert = new ArrayList<>(Arrays.asList(true, false, false));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1018 leetCode1018 = new LeetCode1018();
        List<Boolean> ans = leetCode1018.prefixesDivBy5(new int[]{1, 1, 1});
        List<Boolean> expert = new ArrayList<>(Arrays.asList(false, false, false));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode1018 leetCode1018 = new LeetCode1018();
        List<Boolean> ans = leetCode1018.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1});
        List<Boolean> expert = new ArrayList<>(Arrays.asList(true, false, false, false, true, false));
        assert expert.equals(ans);
    }

    @Test
    public void testCase4() {
        LeetCode1018 leetCode1018 = new LeetCode1018();
        List<Boolean> ans = leetCode1018.prefixesDivBy5(new int[]{1, 1, 1, 0, 1});
        List<Boolean> expert = new ArrayList<>(Arrays.asList(false, false, false, false, false));
        assert expert.equals(ans);
    }
}
