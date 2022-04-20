package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode422 {
    public boolean validWordSquare(List<String> words) {
        List<String> cols = new ArrayList<>();
        return cols.equals(words);
    }

    private List<String> getCols(List<String> words) {
        List<String> ans = new ArrayList<>();
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode422 leetCode422 = new LeetCode422();
        assert leetCode422.validWordSquare(new ArrayList<>(Arrays.asList("abcd", "bnrt", "crmy", "dtye")));
    }

    @Test
    public void testCase2() {
        LeetCode422 leetCode422 = new LeetCode422();
        assert leetCode422.validWordSquare(new ArrayList<>(Arrays.asList("abcd", "bnrt", "crm", "dt")));
    }

    @Test
    public void testCase3() {
        LeetCode422 leetCode422 = new LeetCode422();
        assert leetCode422.validWordSquare(new ArrayList<>(Arrays.asList("ball", "area", "read", "lady")));
    }
}
