package com.geekbing.hard;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * @author bing
 */
public class LeetCode381 {
    private static class RandomizedCollection {
        private final List<Integer> list;
        private final Map<Integer, Set<Integer>> map;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            list.add(val);
            if (!map.containsKey(val)) {
                Set<Integer> idxs = new HashSet<>();
                idxs.add(list.size() - 1);
                map.put(val, idxs);
                return true;
            } else {
                Set<Integer> idxs = map.get(val);
                idxs.add(list.size() - 1);
                map.put(val, idxs);
                return false;
            }
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).size() == 0) {
                return false;
            }

            // 待删除元素的下标
            int valIdx = map.get(val).iterator().next();
            // 待删除元素的值为val

            // 最后一个元素的下标
            int lastIdx = list.size() - 1;
            // 最后一个元素的值
            int lastVal = list.get(lastIdx);

            // 将当前元素赋值为最后一个元素的值
            list.set(valIdx, lastVal);
            map.get(val).remove(valIdx);
            map.get(lastVal).add(valIdx);

            // 删除最后一个元素
            list.remove(lastIdx);
            map.get(lastVal).remove(lastIdx);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            int idx = new Random().nextInt(list.size());
            return list.get(idx);
        }
    }

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();

        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        System.out.println(collection.insert(1));

        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        System.out.println(collection.insert(1));

        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        System.out.println(collection.insert(2));

        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        System.out.println(collection.getRandom());

        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        System.out.println(collection.remove(1));

        // getRandom 应有相同概率返回 1 和 2 。
        System.out.println(collection.getRandom());
    }
}
