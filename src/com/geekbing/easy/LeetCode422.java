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
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size()) {
                    return false;
                }
                if (i >= words.get(j).length()) {
                    return false;
                }
                // 不相等
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode422 leetCode422 = new LeetCode422();
        assert leetCode422.validWordSquare(new ArrayList<>(Arrays.asList(
                "abcd",
                "bnrt",
                "crmy",
                "dtye"
        )));
    }

    @Test
    public void testCase2() {
        LeetCode422 leetCode422 = new LeetCode422();
        assert leetCode422.validWordSquare(new ArrayList<>(Arrays.asList(
                "abcd",
                "bnrt",
                "crm",
                "dt"
        )));
    }

    @Test
    public void testCase3() {
        LeetCode422 leetCode422 = new LeetCode422();
        assert !leetCode422.validWordSquare(new ArrayList<>(Arrays.asList(
                "ball",
                "area",
                "read",
                "lady"
        )));
    }

    @Test
    public void testCase4() {
        LeetCode422 leetCode422 = new LeetCode422();
        assert !leetCode422.validWordSquare(new ArrayList<>(Arrays.asList(
                "ball",
                "asee",
                "let",
                "lep"
        )));
    }
}
