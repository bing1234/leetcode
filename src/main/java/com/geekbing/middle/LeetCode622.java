package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode622 {
    private static class MyCircularQueue {
        /**
         * 双向链表头结点(虚节点)
         */
        private final Node head;

        /**
         * 双向链表尾结点(虚节点)
         */
        private final Node tail;

        /**
         * 双向链表容量
         */
        private final int capacity;

        /**
         * 双向链表当前实际节点数
         */
        private int size;

        public MyCircularQueue(int k) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            capacity = k;
            size = 0;
        }

        public boolean enQueue(int value) {
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

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            Node cur = head.next;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return head.next.val;
        }

        public int Rear() {
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
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        assert circularQueue.enQueue(1); // 返回 true
        assert circularQueue.enQueue(2); // 返回 true
        assert circularQueue.enQueue(3); // 返回 true
        assert !circularQueue.enQueue(4); // 返回 false，队列已满
        assert circularQueue.Rear() == 3; // 返回 3
        assert circularQueue.isFull(); // 返回 true
        assert circularQueue.deQueue(); // 返回 true
        assert circularQueue.enQueue(4); // 返回 true
        assert circularQueue.Rear() == 4; // 返回 4
    }

    @Test
    public void testCase2() {
        MyCircularQueue circularQueue = new MyCircularQueue(8);
        assert circularQueue.enQueue(3);
        assert circularQueue.enQueue(9);
        assert circularQueue.enQueue(5);
        assert circularQueue.enQueue(0);
        assert circularQueue.deQueue();
        assert circularQueue.deQueue();
        assert !circularQueue.isEmpty();
        assert !circularQueue.isEmpty();
        assert circularQueue.Rear() == 0;
        assert circularQueue.Rear() == 0;
        assert circularQueue.deQueue();
    }
}
