package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 存储课程-课程的入度
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            degreeMap.put(i, 0);
        }
        for (int[] arr : prerequisites) {
            degreeMap.put(arr[0], degreeMap.getOrDefault(arr[0], 0) + 1);
        }
        // 存储课程 -> 课程所有的后继节点
        Map<Integer, Set<Integer>> relationMap = new HashMap<>();
        for (int[] arr : prerequisites) {
            Set<Integer> set = relationMap.getOrDefault(arr[1], new HashSet<>());
            set.add(arr[0]);
            relationMap.put(arr[1], set);
        }
        Queue<Integer> queue = new LinkedList<>();
        degreeMap.forEach((key, val) -> {
            if (val == 0) {
                queue.offer(key);
            }
        });

        int[] ans = new int[numCourses];
        int cnt = 0, idx = 0;
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            ans[idx++] = num;

            Set<Integer> set = relationMap.getOrDefault(num, new HashSet<>());
            cnt++;
            if (set.size() == 0) {
                continue;
            }
            for (Integer item : set) {
                int val = degreeMap.get(item);
                if (val == 1) {
                    queue.offer(item);
                }
                degreeMap.put(item, val - 1);
            }
        }
        if (cnt != numCourses) {
            return new int[]{};
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode210 leetCode210 = new LeetCode210();
        int[] ans = leetCode210.findOrder(2, new int[][]{{1, 0}});
        assert Arrays.equals(ans, new int[]{0, 1});
    }

    @Test
    public void testCase2() {
        LeetCode210 leetCode210 = new LeetCode210();
        int[] ans = leetCode210.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assert Arrays.equals(ans, new int[]{0, 1, 2, 3}) || Arrays.equals(ans, new int[]{0, 2, 1, 3});
    }

    @Test
    public void testCase3() {
        LeetCode210 leetCode210 = new LeetCode210();
        int[] ans = leetCode210.findOrder(1, new int[][]{});
        assert Arrays.equals(ans, new int[]{0});
    }
}
