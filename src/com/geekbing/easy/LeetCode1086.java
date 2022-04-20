package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode1086 {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            PriorityQueue<Integer> queue = map.getOrDefault(item[0], new PriorityQueue<>(5));
            queue.offer(item[1]);
            if (queue.size() > 5) {
                queue.poll();
            }
            map.put(item[0], queue);
        }
        int[][] ans = new int[map.size()][2];
        List<Integer> ids = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < ids.size(); i++) {
            ans[i][0] = ids.get(i);
            PriorityQueue<Integer> queue = map.get(ids.get(i));
            while (!queue.isEmpty()) {
                ans[i][1] += queue.poll();
            }
            ans[i][1] /= 5;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1086 leetCode1086 = new LeetCode1086();
        int[][] ans = leetCode1086.highFive(new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}});
        int[][] expert = new int[][]{{1, 87}, {2, 88}};
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode1086 leetCode1086 = new LeetCode1086();
        int[][] ans = leetCode1086.highFive(new int[][]{{1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}});
        int[][] expert = new int[][]{{1, 100}, {7, 100}};
        assert Arrays.deepEquals(expert, ans);
    }
}
