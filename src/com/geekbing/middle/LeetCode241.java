package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode241 {
    public List<Integer> diffWaysToCompute(String expression) {
        return new ArrayList<>();
    }

    @Test
    public void testCase1() {
        LeetCode241 leetCode241 = new LeetCode241();
        List<Integer> ans = leetCode241.diffWaysToCompute("2-1-1");
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 2));
        ans = ans.stream().sorted().collect(Collectors.toList());
        expert = expert.stream().sorted().collect(Collectors.toList());
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode241 leetCode241 = new LeetCode241();
        List<Integer> ans = leetCode241.diffWaysToCompute("2*3-4*5");
        List<Integer> expert = new ArrayList<>(Arrays.asList(-34, -14, -10, -10, 10));
        ans = ans.stream().sorted().collect(Collectors.toList());
        expert = expert.stream().sorted().collect(Collectors.toList());
        assert expert.equals(ans);
    }
}
