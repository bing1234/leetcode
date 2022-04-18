package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        if (currentState.length() < 2) {
            return ans;
        }
        for (int i = 1; i < currentState.length(); i++) {
            if (currentState.charAt(i - 1) == '+' && currentState.charAt(i) == '+') {
                ans.add(currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1));
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode293 leetCode293 = new LeetCode293();
        List<String> ans = leetCode293.generatePossibleNextMoves("++++");
        List<String> expert = new ArrayList<>(Arrays.asList("--++", "+--+", "++--"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode293 leetCode293 = new LeetCode293();
        List<String> ans = leetCode293.generatePossibleNextMoves("+");
        assert new ArrayList<>().equals(ans);
    }
}
