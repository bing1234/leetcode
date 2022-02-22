package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author bing
 */
public class OfferII074 {
    public int[][] merge(int[][] intervals) {
        // 按照左点进行从大到小排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] ans = new int[intervals.length][2];
        ans[0] = intervals[0];
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > ans[idx][1]) {
                idx++;
                ans[idx] = intervals[i];
            } else {
                ans[idx][1] = Math.max(ans[idx][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }

    @Test
    public void testCase1() {
        OfferII074 offerII074 = new OfferII074();
        int[][] ans = offerII074.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] expert = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        OfferII074 offerII074 = new OfferII074();
        int[][] ans = offerII074.merge(new int[][]{{1, 4}, {4, 5}});
        int[][] expert = new int[][]{{1, 5}};
        assert Arrays.deepEquals(expert, ans);
    }
}
