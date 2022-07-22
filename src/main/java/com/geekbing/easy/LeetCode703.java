package com.geekbing.easy;

import java.util.PriorityQueue;

/**
 * @author bing
 */
public class LeetCode703 {
    private static final class KthLargest {
        private final PriorityQueue<Integer> queue;
        private final int size;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>(k);
            size = k;
            for (int num : nums) {
                queue.offer(num);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        public int add(int val) {
            queue.offer(val);
            if (queue.size() > size) {
                queue.poll();
            }
            return !queue.isEmpty() ? queue.peek() : -1;
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest1 = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest1.add(3));   // return 4
        System.out.println(kthLargest1.add(5));   // return 5
        System.out.println(kthLargest1.add(10));  // return 5
        System.out.println(kthLargest1.add(9));   // return 8
        System.out.println(kthLargest1.add(4));   // return 8

        KthLargest kthLargest2 = new KthLargest(1, new int[]{});
        System.out.println(kthLargest2.add(-3));
        System.out.println(kthLargest2.add(-2));
        System.out.println(kthLargest2.add(-4));
        System.out.println(kthLargest2.add(0));
        System.out.println(kthLargest2.add(4));
    }
}
