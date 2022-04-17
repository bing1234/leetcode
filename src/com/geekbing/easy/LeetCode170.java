package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode170 {
    private static class TwoSum {
        private final Map<Integer, Integer> map;

        public TwoSum() {
            map = new HashMap<>();
        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (Integer num : map.keySet()) {
                int diff = value - num;
                if (map.containsKey(diff)) {
                    if (diff != num || map.get(num) >= 2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Test
    public void testCase1() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);   // [] --> [1]
        twoSum.add(3);   // [1] --> [1,3]
        twoSum.add(5);   // [1,3] --> [1,3,5]
        assert twoSum.find(4);  // 1 + 3 = 4，返回 true
        assert !twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false
    }

    @Test
    public void testCase2() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        twoSum.add(-1);
        twoSum.add(1);
        assert twoSum.find(0);
    }
}
