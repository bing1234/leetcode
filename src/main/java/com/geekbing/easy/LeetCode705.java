package com.geekbing.easy;

import java.util.LinkedList;
import java.util.List;

public class LeetCode705 {
    private static class MyHashSet {
        private final List<Integer>[] buckets;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            buckets = new List[1024];
        }

        public void add(int key) {
            // 先定位到桶的下标
            int idx = key % buckets.length;
            List<Integer> bucket = buckets[idx];
            if (bucket == null) {
                bucket = new LinkedList<>();
            }
            bucket.add(key);
            buckets[idx] = bucket;
        }

        public void remove(int key) {
            // 先定位到桶的下标
            int idx = key % buckets.length;
            List<Integer> bucket = buckets[idx];
            if (bucket != null) {
                bucket.removeIf(item -> item.equals(key));
                buckets[idx] = bucket;
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            // 先定位到桶的下标
            int idx = key % buckets.length;
            List<Integer> bucket = buckets[idx];
            if (bucket != null) {
                for (Integer item : bucket) {
                    if (item.equals(key)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));// 返回 true
        System.out.println(hashSet.contains(3));// 返回 false (未找到)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));// 返回 true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));// 返回  false (已经被删除)
    }
}
