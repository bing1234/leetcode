package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode6016 {
    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();
        char col1 = s.charAt(0), row1 = s.charAt(1), col2 = s.charAt(3), row2 = s.charAt(4);
        for (int j = col1; j <= col2; j++) {
            for (int i = row1; i <= row2; i++) {
                ans.add(String.valueOf((char) j) + (char) i);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6016 leetCode6016 = new LeetCode6016();
        List<String> ans = leetCode6016.cellsInRange("K1:L2");
        List<String> expert = new ArrayList<>(Arrays.asList("K1", "K2", "L1", "L2"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode6016 leetCode6016 = new LeetCode6016();
        List<String> ans = leetCode6016.cellsInRange("A1:F1");
        List<String> expert = new ArrayList<>(Arrays.asList("A1", "B1", "C1", "D1", "E1", "F1"));
        assert expert.equals(ans);
    }
}
