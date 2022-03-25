package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode641 {
    private static class MyCircularDeque {
        private final Node head;
        private final Node tail;
        private final int capacity;
        private int size;

        public MyCircularDeque(int k) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            capacity = k;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            Node cur = new Node(value);
            cur.prev = head;
            cur.next = head.next;
            head.next.prev = cur;
            head.next = cur;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            Node cur = new Node(value);
            cur.prev = tail.prev;
            cur.next = tail;
            tail.prev.next = cur;
            tail.prev = cur;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head.next.next.prev = head;
            head.next = head.next.next;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return head.next.val;
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.prev.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
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
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        assert circularDeque.insertLast(1);                  // 返回 true
        assert circularDeque.insertLast(2);                  // 返回 true
        assert circularDeque.insertFront(3);                 // 返回 true
        assert !circularDeque.insertFront(4);                // 已经满了，返回 false
        assert circularDeque.getRear() == 2;                       // 返回 2
        assert circularDeque.isFull();                             // 返回 true
        assert circularDeque.deleteLast();                         // 返回 true
        assert circularDeque.insertFront(4);                 // 返回 true
        assert circularDeque.getFront() == 4;                      // 返回 4
    }
}
