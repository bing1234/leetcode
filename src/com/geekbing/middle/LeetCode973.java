package com.geekbing.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
        return Arrays.copyOf(points, K);
    }

    public int[][] kClosestV2(int[][] points, int K) {
        // 下标-距离
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < K; i++) {
            queue.offer(new int[]{i, points[i][0] * points[i][0] + points[i][1] * points[i][1]});
        }
        for (int i = K; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (!queue.isEmpty() && distance < queue.peek()[1]) {
                queue.poll();
                queue.offer(new int[]{i, distance});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K && !queue.isEmpty(); i++) {
            ans[i] = points[queue.poll()[0]];
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode973 leetCode973 = new LeetCode973();
        System.out.println(Arrays.deepToString(leetCode973.kClosestV2(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(leetCode973.kClosestV2(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
