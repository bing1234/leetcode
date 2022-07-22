package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 组合两个数组
        int[][] combine = new int[firstList.length + secondList.length][2];
        System.arraycopy(firstList, 0, combine, 0, firstList.length);
        System.arraycopy(secondList, 0, combine, firstList.length, secondList.length);

        // 升序排列
        Arrays.sort(combine, (Comparator.comparingInt(o -> o[0])));

        List<int[]> list = new ArrayList<>();

        int preEnd = combine[0][1];
        for (int i = 1; i < combine.length; i++) {
            if (combine[i][0] > preEnd) {
                preEnd = combine[i][1];
            } else {
                list.add(new int[]{combine[i][0], Math.min(combine[i][1], preEnd)});
                preEnd = Math.max(preEnd, combine[i][1]);
            }
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode986 leetCode986 = new LeetCode986();
        int[][] ans = leetCode986.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        int[][] expert = new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode986 leetCode986 = new LeetCode986();
        int[][] ans = leetCode986.intervalIntersection(new int[][]{{1, 3}, {5, 9}}, new int[][]{});
        assert Arrays.deepEquals(new int[][]{}, ans);
    }

    @Test
    public void testCase3() {
        LeetCode986 leetCode986 = new LeetCode986();
        int[][] ans = leetCode986.intervalIntersection(new int[][]{}, new int[][]{{4, 8}, {10, 12}});
        assert Arrays.deepEquals(new int[][]{}, ans);
    }

    @Test
    public void testCase4() {
        LeetCode986 leetCode986 = new LeetCode986();
        int[][] ans = leetCode986.intervalIntersection(new int[][]{{1, 7}}, new int[][]{{3, 10}});
        int[][] expert = new int[][]{{3, 7}};
        assert Arrays.deepEquals(expert, ans);
    }
}
