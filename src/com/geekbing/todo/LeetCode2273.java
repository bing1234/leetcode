package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();

        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2273 leetCode2273 = new LeetCode2273();
        List<String> ans = leetCode2273.removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"});
        List<String> expert = new ArrayList<>(Arrays.asList("abba", "cd"));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2273 leetCode2273 = new LeetCode2273();
        List<String> ans = leetCode2273.removeAnagrams(new String[]{"a", "b", "c", "d", "e"});
        List<String> expert = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        assert expert.equals(ans);
    }
}
