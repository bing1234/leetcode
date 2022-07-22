package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    private int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    @Test
    public void testCase1() {
        LeetCode1447 leetCode1447 = new LeetCode1447();
        List<String> ans = leetCode1447.simplifiedFractions(2);
        List<String> expert = new ArrayList<>(Collections.singletonList("1/2"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1447 leetCode1447 = new LeetCode1447();
        List<String> ans = leetCode1447.simplifiedFractions(3);
        List<String> expert = new ArrayList<>(Arrays.asList("1/2", "1/3", "2/3"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode1447 leetCode1447 = new LeetCode1447();
        List<String> ans = leetCode1447.simplifiedFractions(4);
        List<String> expert = new ArrayList<>(Arrays.asList("1/2", "1/3", "1/4", "2/3", "3/4"));

        ans = ans.stream().sorted().collect(Collectors.toList());
        expert = expert.stream().sorted().collect(Collectors.toList());
        assert expert.equals(ans);
    }

    @Test
    public void testCase4() {
        LeetCode1447 leetCode1447 = new LeetCode1447();
        List<String> ans = leetCode1447.simplifiedFractions(1);
        assert new ArrayList<>().equals(ans);
    }
}
