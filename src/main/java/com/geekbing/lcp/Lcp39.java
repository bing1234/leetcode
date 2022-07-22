package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class Lcp39 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> sourceMap = buildMap(source);
        Map<Integer, Integer> targetMap = buildMap(target);
        int ans = 0;
        for (int key : sourceMap.keySet()) {
            int sourceVal = sourceMap.get(key);
            int targetVal = targetMap.getOrDefault(key, 0);
            if (sourceVal > targetVal) {
                ans += sourceVal - targetVal;
            }
        }
        return ans;
    }

    private Map<Integer, Integer> buildMap(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : matrix) {
            for (int num : line) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return map;
    }

    @Test
    public void testCase1() {
        Lcp39 lcp39 = new Lcp39();
        int[][] source = new int[][]{{1, 3}, {5, 4}};
        int[][] target = new int[][]{{3, 1}, {6, 5}};
        assert lcp39.minimumSwitchingTimes(source, target) == 1;
    }

    @Test
    public void testCase2() {
        Lcp39 lcp39 = new Lcp39();
        int[][] source = new int[][]{{1, 2, 3}, {3, 4, 5}};
        int[][] target = new int[][]{{1, 3, 5}, {2, 3, 4}};
        assert lcp39.minimumSwitchingTimes(source, target) == 0;
    }
}
