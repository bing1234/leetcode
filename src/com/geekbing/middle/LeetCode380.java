package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode380 {
    private static class RandomizedSet {
        private final List<Integer> list;
        // 值和索引的映射
        private final Map<Integer, Integer> map;
        private final Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            // 最后一个元素
            int lastElement = list.get(list.size() - 1);
            // 待删除元素的下标
            int idx = map.get(val);

            list.set(idx, lastElement);
            map.put(lastElement, idx);

            // 删除最后一个元素
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }
    }

    @Test
    public void testCase1() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assert randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        assert !randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
        assert randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        int ans = randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
        assert ans == 1 || ans == 2;
        assert randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        assert !randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
        ans = randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        assert ans == 2;
    }
}
