package com.geekbing.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return -1;
            } else if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return 1;
            }
        });
        List<int[]> ans = new LinkedList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        LeetCode406 leetCode406 = new LeetCode406();
        System.out.println(Arrays.deepToString(leetCode406.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
}
