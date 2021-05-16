package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode703 {
    private static final class KthLargest {

        public KthLargest(int k, int[] nums) {

        }

        public int add(int val) {
            return 0;
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }
}
