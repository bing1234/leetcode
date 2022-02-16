package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, Set<Integer>> map = buildMap(graph);
        return travel(map, graph.length - 1).stream().filter(o -> o.get(0) == 0).collect(Collectors.toList());
    }

    private List<List<Integer>> travel(Map<Integer, Set<Integer>> map, int point) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<Integer> set = map.getOrDefault(point, new HashSet<>());
        if (set.isEmpty()) {
            ans.add(new ArrayList<>(Collections.singletonList(point)));
            return ans;
        }

        for (Integer p : set) {
            List<List<Integer>> paths = travel(map, p);
            for (List<Integer> path : paths) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(point);
                ans.add(newPath);
            }
        }
        return ans;
    }

    private Map<Integer, Set<Integer>> buildMap(int[][] graph) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            for (int point : graph[i]) {
                Set<Integer> set = map.getOrDefault(point, new HashSet<>());
                set.add(i);
                map.put(point, set);
            }
        }
        return map;
    }

    @Test
    public void testCase1() {
        LeetCode797 leetCode797 = new LeetCode797();

        List<List<Integer>> paths = leetCode797.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 3)));
        expert.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        paths = paths.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
        expert = expert.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
        assert expert.equals(paths);
    }

    @Test
    public void testCase2() {
        LeetCode797 leetCode797 = new LeetCode797();

        List<List<Integer>> paths = leetCode797.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(0, 4)));
        expert.add(new ArrayList<>(Arrays.asList(0, 3, 4)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 3, 4)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4)));
        expert.add(new ArrayList<>(Arrays.asList(0, 1, 4)));

        paths = paths.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
        expert = expert.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
        assert expert.equals(paths);
    }

    @Test
    public void testCase3() {
        LeetCode797 leetCode797 = new LeetCode797();

        List<List<Integer>> paths = leetCode797.allPathsSourceTarget(new int[][]{{2}, {2}, {}});
        List<List<Integer>> expert = new ArrayList<>();
        expert.add(new ArrayList<>(Arrays.asList(0, 2)));

        paths = paths.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
        expert = expert.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
        assert expert.equals(paths);
    }
}
