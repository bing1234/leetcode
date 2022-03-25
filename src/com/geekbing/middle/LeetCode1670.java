package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1670 {
    private static class FrontMiddleBackQueue {
        private Node head;
        private Node middle;
        private Node tail;

        public FrontMiddleBackQueue() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void pushFront(int val) {
            Node cur = new Node(val);
            cur.prev = head;
            cur.next = head.next;
            head.next.prev = cur;
            head.next = cur;
        }

        public void pushMiddle(int val) {
            
        }

        public void pushBack(int val) {
            Node cur = new Node(val);
            cur.prev = tail.prev;
            cur.next = tail;
            tail.prev.next = cur;
            tail.prev = cur;
        }

        public int popFront() {
            if (head.next == tail) {
                return -1;
            }
            Node cur = head.next;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            return cur.val;
        }

        public int popMiddle() {
            return 0;
        }

        public int popBack() {
            Node cur = tail.prev;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            return cur.val;
        }

        private static class Node {
            private int val;
            private Node prev;
            private Node next;

            public Node() {
            }

            public Node(int val) {
                this.val = val;
            }
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
