package com.geekbing.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode706 {
    private static final class Tuple<A, B> {
        private Integer A;
        private Integer B;

        public Tuple() {
        }

        public Tuple(Integer a, Integer b) {
            A = a;
            B = b;
        }

        public Integer getA() {
            return A;
        }

        public void setA(Integer a) {
            A = a;
        }

        public Integer getB() {
            return B;
        }

        public void setB(Integer b) {
            B = b;
        }
    }

    private static final class MyHashMap {
        private final List<Tuple>[] buckets;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            buckets = new List[1024];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            // 先根据key确定bucket的下标
            int idx = key % buckets.length;
            List<Tuple> bucket = buckets[idx];
            if (bucket == null) {
                bucket = new LinkedList<>();
            }
            bucket.removeIf(tuple -> tuple.getA() == key);
            bucket.add(new Tuple(key, value));
            buckets[idx] = bucket;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            // 先根据key确定bucket的下标
            int idx = key % buckets.length;
            List<Tuple> bucket = buckets[idx];
            if (bucket == null) {
                return -1;
            }
            for (Tuple tuple : bucket) {
                if (tuple.getA() == key) {
                    return tuple.getB();
                }
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            // 先根据key确定bucket的下标
            int idx = key % buckets.length;
            List<Tuple> bucket = buckets[idx];
            if (bucket != null) {
                bucket.removeIf(tuple -> tuple.getA() == key);
            }
            buckets[idx] = bucket;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2));    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }
}
