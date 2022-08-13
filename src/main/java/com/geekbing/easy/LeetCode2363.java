package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : items1) {
            map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
        }
        for (int[] arr : items2) {
            map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        map.forEach((val, weight) -> ans.add(new ArrayList<>(Arrays.asList(val, weight))));
        ans.sort((Comparator.comparing(o -> o.get(0))));
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2363 leetCode2363 = new LeetCode2363();
        List<List<Integer>> ans = leetCode2363.mergeSimilarItems(new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(1, 6)));
        expert.add(new ArrayList<>(Arrays.asList(3, 9)));
        expert.add(new ArrayList<>(Arrays.asList(4, 5)));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2363 leetCode2363 = new LeetCode2363();
        List<List<Integer>> ans = leetCode2363.mergeSimilarItems(new int[][]{{1, 1}, {3, 2}, {2, 3}}, new int[][]{{2, 1}, {3, 2}, {1, 3}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(1, 4)));
        expert.add(new ArrayList<>(Arrays.asList(2, 4)));
        expert.add(new ArrayList<>(Arrays.asList(3, 4)));
        assert expert.equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode2363 leetCode2363 = new LeetCode2363();
        List<List<Integer>> ans = leetCode2363.mergeSimilarItems(new int[][]{{1, 3}, {2, 2}}, new int[][]{{7, 1}, {2, 2}, {1, 4}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(1, 7)));
        expert.add(new ArrayList<>(Arrays.asList(2, 4)));
        expert.add(new ArrayList<>(Arrays.asList(7, 1)));
        assert expert.equals(ans);
    }
}
