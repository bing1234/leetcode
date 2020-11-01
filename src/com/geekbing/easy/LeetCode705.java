package com.geekbing.easy;

public class LeetCode705 {
    private static class MyHashSet {

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {

        }

        public void add(int key) {

        }

        public void remove(int key) {

        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {

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
