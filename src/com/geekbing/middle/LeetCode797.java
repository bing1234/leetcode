package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 */
public class LeetCode797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode797 leetCode797 = new LeetCode797();
        System.out.println(leetCode797.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(leetCode797.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
        System.out.println(leetCode797.allPathsSourceTarget(new int[][]{{1}, {}}));
        System.out.println(leetCode797.allPathsSourceTarget(new int[][]{{1, 2, 3}, {2}, {3}, {}}));
        System.out.println(leetCode797.allPathsSourceTarget(new int[][]{{1, 3}, {2}, {3}, {}}));
    }
}
