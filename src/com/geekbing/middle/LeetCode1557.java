package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

    }

    public static void main(String[] args) {
        LeetCode1557 leetCode1557 = new LeetCode1557();

        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges1.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges1.add(new ArrayList<>(Arrays.asList(2, 5)));
        edges1.add(new ArrayList<>(Arrays.asList(3, 4)));
        edges1.add(new ArrayList<>(Arrays.asList(4, 2)));
        System.out.println(leetCode1557.findSmallestSetOfVertices(6, edges1));

        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges2.add(new ArrayList<>(Arrays.asList(2, 1)));
        edges2.add(new ArrayList<>(Arrays.asList(3, 1)));
        edges2.add(new ArrayList<>(Arrays.asList(1, 4)));
        edges2.add(new ArrayList<>(Arrays.asList(2, 4)));
        System.out.println(leetCode1557.findSmallestSetOfVertices(5, edges2));
    }
}
