package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode386 {
    public List<Integer> lexicalOrder(int n) {

        return new ArrayList<>();
    }

    @Test
    public void testCase1() {
        LeetCode386 leetCode386 = new LeetCode386();
        List<Integer> ans = leetCode386.lexicalOrder(13);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode386 leetCode386 = new LeetCode386();
        List<Integer> ans = leetCode386.lexicalOrder(2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2));
        assert expert.equals(ans);
    }
}
