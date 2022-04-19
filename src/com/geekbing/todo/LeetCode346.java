package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode346 {
    private static class MovingAverage {
        /**
         * 链表当前长度、总和、最大容量
         */
        private int len, sum;
        private final int size;

        /**
         * 双链表的头尾指针(虚节点)
         */
        private final Node head, tail;

        public MovingAverage(int size) {
            this.len = 0;
            this.size = size;
            this.sum = 0;
            head = new Node(0);
            tail = new Node(0);

            head.next = tail;
            tail.prev = head;
        }

        public double next(int val) {
            // 在尾巴添加当前一个元素
            Node cur = new Node(val);
            cur.prev = tail.prev;
            cur.next = tail;
            tail.prev.next = cur;
            tail.prev = cur;

            sum += val;
            if (len < size) {
                len++;
            } else {
                sum -= head.next.val;
                // 删除头部的节点
                Node del = head.next;
                head.next = del.next;
                del.next.prev = head;
            }
            return (double) sum / (double) len;
        }
    }

    private static class Node {
        private final int val;
        private Node prev;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCase1() {
        MovingAverage movingAverage = new MovingAverage(3);
        assert doubleEqual(movingAverage.next(1), 1.0D);     // 返回 1.0 = 1 / 1
        assert doubleEqual(movingAverage.next(10), 5.5D);    // 返回 5.5 = (1 + 10) / 2
        assert doubleEqual(movingAverage.next(3), 4.66667D); // 返回 4.66667 = (1 + 10 + 3) / 3
        assert doubleEqual(movingAverage.next(5), 6.0D);     // 返回 6.0 = (10 + 3 + 5) / 3
    }

    private boolean doubleEqual(double d1, double d2) {
        return Math.abs(d1 - d2) <= 0.00001D;
    }
}
