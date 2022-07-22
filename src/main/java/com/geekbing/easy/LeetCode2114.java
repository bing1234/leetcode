package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2114 {
    public int mostWordsFound(String[] sentences) {
        // return Arrays.stream(sentences).mapToInt(s-> s.split(" ").length).max().orElse(0);

        return Arrays.stream(sentences).mapToInt(s -> {
            int ans = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    ans++;
                }
            }
            return ans + 1;
        }).max().orElse(0);
    }

    @Test
    public void testCase1() {
        LeetCode2114 leetCode2114 = new LeetCode2114();
        assert leetCode2114.mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode2114 leetCode2114 = new LeetCode2114();
        assert leetCode2114.mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"}) == 3;
    }
}
