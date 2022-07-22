package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author bing
 */
public class LeetCode1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = IntStream.range(0, n).boxed().collect(Collectors.toSet());
        for (List<Integer> edge : edges) {
            set.remove(edge.get(1));
        }
        return new ArrayList<>(set);
    }

    @Test
    public void testCase1() {
        LeetCode1557 leetCode1557 = new LeetCode1557();
        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges1.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges1.add(new ArrayList<>(Arrays.asList(2, 5)));
        edges1.add(new ArrayList<>(Arrays.asList(3, 4)));
        edges1.add(new ArrayList<>(Arrays.asList(4, 2)));
        List<Integer> ans = leetCode1557.findSmallestSetOfVertices(6, edges1);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 3));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1557 leetCode1557 = new LeetCode1557();

        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges2.add(new ArrayList<>(Arrays.asList(2, 1)));
        edges2.add(new ArrayList<>(Arrays.asList(3, 1)));
        edges2.add(new ArrayList<>(Arrays.asList(1, 4)));
        edges2.add(new ArrayList<>(Arrays.asList(2, 4)));

        List<Integer> ans = leetCode1557.findSmallestSetOfVertices(5, edges2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 2, 3));
        assert expert.equals(ans);
    }
}
