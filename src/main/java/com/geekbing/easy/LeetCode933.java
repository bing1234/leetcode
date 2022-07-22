package com.geekbing.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100));   // requests = [<u>1</u>, <u>100</u>]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001));  // requests = [<u>1</u>, <u>100</u>, <u>3001</u>]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, <u>100</u>, <u>3001</u>, <u>3002</u>]，范围是 [2,3002]，返回 3
    }

    private static class RecentCounter {
        private final Queue<Integer> queue;
        private int size;

        public RecentCounter() {
            queue = new LinkedList<>();
            size = 0;
        }

        public int ping(int t) {
            queue.offer(t);
            size++;
            while (!queue.isEmpty()) {
                Integer num = queue.peek();
                if (num < t - 3000) {
                    queue.poll();
                    size--;
                } else {
                    break;
                }
            }
            return size;
        }
    }
}
