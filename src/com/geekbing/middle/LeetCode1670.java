package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1670 {
    private static class FrontMiddleBackQueue {

        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {

        }

        public void pushMiddle(int val) {

        }

        public void pushBack(int val) {

        }

        public int popFront() {
            return 0;
        }

        public int popMiddle() {
            return 0;
        }

        public int popBack() {
            return 0;
        }
    }

    @Test
    public void testCase1() {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        assert q.popFront() == 1;     // 返回 1 -> [4, 3, 2]
        assert q.popMiddle() == 3;    // 返回 3 -> [4, 2]
        assert q.popMiddle() == 4;    // 返回 4 -> [2]
        assert q.popBack() == 2;      // 返回 2 -> []
        assert q.popFront() == -1;     // 返回 -1 -> [] （队列为空）
    }
}
