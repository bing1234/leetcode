package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2192 leetCode2192 = new LeetCode2192();
        List<List<Integer>> ans = leetCode2192.getAncestors(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>(Arrays.asList(0, 1)));
        expert.add(new ArrayList<>(Arrays.asList(0, 2)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 3)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 2, 3)));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2192 leetCode2192 = new LeetCode2192();
        List<List<Integer>> ans = leetCode2192.getAncestors(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>());
        expert.add(new ArrayList<>(Collections.singletonList(0)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 2)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 2, 3)));
        assert expert.equals(ans);
    }
}
