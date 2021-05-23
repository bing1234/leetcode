package com.geekbing.lcp;

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

    public static void main(String[] args) {
        Lcp11 lcp11 = new Lcp11();
        System.out.println(lcp11.expectNumber(new int[]{1, 2, 3}));
        System.out.println(lcp11.expectNumber(new int[]{1, 1}));
    }
}
