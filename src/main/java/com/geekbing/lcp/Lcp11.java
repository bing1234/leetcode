package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class Lcp11 {
    public int expectNumber(int[] scores) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int score : scores) {
            Integer count = countMap.get(score);
            if (count == null) {
                count = 0;
            }
            countMap.put(score, count + 1);
        }
        return countMap.keySet().size();
    }

    @Test
    public void testCase1() {
        Lcp11 lcp11 = new Lcp11();
        assert lcp11.expectNumber(new int[]{1, 2, 3}) == 3;
    }

    @Test
    public void testCase2() {
        Lcp11 lcp11 = new Lcp11();
        assert lcp11.expectNumber(new int[]{1, 1}) == 1;
    }

    @Test
    public void testCase3() {
        Lcp11 lcp11 = new Lcp11();
        assert lcp11.expectNumber(new int[]{1, 1, 2}) == 2;
    }
}
