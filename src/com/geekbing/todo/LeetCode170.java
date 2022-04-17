package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode170 {
    private static class TwoSum {

        public TwoSum() {

        }

        public void add(int number) {

        }

        public boolean find(int value) {
            return true;
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
}
