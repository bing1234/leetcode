package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class Lcp51 {
    private List<List<Integer>> lists;

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        // 获取所有料理的组合
        subsets(cookbooks.length);
        int ans = -1;
        for (List<Integer> list : lists) {
            if (canComplete(list, materials, cookbooks, attribute, limit)) {
                int good = list.stream().map(idx -> attribute[idx][0]).reduce(0, Integer::sum);
                ans = Math.max(ans, good);
            }
        }
        return ans;
    }

    private boolean canComplete(List<Integer> list, int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int full = 0;
        int[] temp = materials.clone();
        for (int idx : list) {
            int[] cookbook = cookbooks[idx];
            for (int i = 0; i < cookbook.length; i++) {
                if (temp[i] < cookbook[i]) {
                    return false;
                }
                temp[i] -= cookbook[i];
            }
            full += attribute[idx][1];
        }
        return full >= limit;
    }

    private void subsets(int len) {
        lists = new ArrayList<>();
        backtrack(new ArrayList<>(), len, 0);
    }

    private void backtrack(List<Integer> cur, int len, int i) {
        lists.add(new ArrayList<>(cur));
        for (int j = i; j < len; j++) {
            cur.add(j);
            backtrack(cur, len, j + 1);
            cur.remove(cur.size() - 1);
        }
    }

    @Test
    public void testCase1() {
        Lcp51 lcp51 = new Lcp51();
        int ans = lcp51.perfectMenu(new int[]{3, 2, 4, 1, 2},
                new int[][]{{1, 1, 0, 1, 2}, {2, 1, 4, 0, 0}, {3, 2, 4, 1, 0}},
                new int[][]{{3, 2}, {2, 4}, {7, 6}},
                5);
        assert ans == 7;
    }

    @Test
    public void testCase2() {
        Lcp51 lcp51 = new Lcp51();
        int ans = lcp51.perfectMenu(new int[]{10, 10, 10, 10, 10},
                new int[][]{{1, 1, 1, 1, 1}, {3, 3, 3, 3, 3}, {10, 10, 10, 10, 10}},
                new int[][]{{5, 5}, {6, 6}, {10, 10}},
                1);
        assert ans == 11;
    }
}
