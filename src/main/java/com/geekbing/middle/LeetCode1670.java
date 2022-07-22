package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1670 {
    private static class FrontMiddleBackQueue {
        private final DoubleEndedLink firstDoubleEndedLink;
        private final DoubleEndedLink secondDoubleEndedLink;

        public FrontMiddleBackQueue() {
            firstDoubleEndedLink = new DoubleEndedLink();
            secondDoubleEndedLink = new DoubleEndedLink();
        }

        public void pushFront(int val) {
            firstDoubleEndedLink.pushFront(val);
            adjust();
        }

        public void pushMiddle(int val) {
            if (firstDoubleEndedLink.size < secondDoubleEndedLink.size) {
                firstDoubleEndedLink.pushBack(val);
            } else {
                secondDoubleEndedLink.pushFront(val);
            }
        }

        public void pushBack(int val) {
            secondDoubleEndedLink.pushBack(val);
            adjust();
        }

        public int popFront() {
            if (firstDoubleEndedLink.isNotEmpty()) {
                int ans = firstDoubleEndedLink.popFront();
                adjust();
                return ans;
            }
            if (secondDoubleEndedLink.isNotEmpty()) {
                int ans = secondDoubleEndedLink.popFront();
                adjust();
                return ans;
            }
            return -1;
        }

        public int popMiddle() {
            if (firstDoubleEndedLink.isEmpty() && secondDoubleEndedLink.isEmpty()) {
                return -1;
            }
            if (firstDoubleEndedLink.isEmpty()) {
                return secondDoubleEndedLink.popFront();
            }
            if (secondDoubleEndedLink.isEmpty()) {
                return firstDoubleEndedLink.popBack();
            }
            if (firstDoubleEndedLink.size < secondDoubleEndedLink.size) {
                return secondDoubleEndedLink.popFront();
            } else {
                return firstDoubleEndedLink.popBack();
            }
        }

        public int popBack() {
            if (secondDoubleEndedLink.isNotEmpty()) {
                int ans = secondDoubleEndedLink.popBack();
                adjust();
                return ans;
            }
            if (firstDoubleEndedLink.isNotEmpty()) {
                int ans = firstDoubleEndedLink.popBack();
                adjust();
                return ans;
            }
            return -1;
        }

        private void adjust() {
            if (firstDoubleEndedLink.size > secondDoubleEndedLink.size) {
                secondDoubleEndedLink.pushFront(firstDoubleEndedLink.popBack());
            }
            if (secondDoubleEndedLink.size - firstDoubleEndedLink.size >= 2) {
                firstDoubleEndedLink.pushBack(secondDoubleEndedLink.popFront());
            }
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

        private static class DoubleEndedLink {
            private final Node head;
            private final Node tail;
            private int size;

            public DoubleEndedLink() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            private void pushFront(int val) {
                Node cur = new Node(val);
                cur.prev = head;
                cur.next = head.next;
                head.next.prev = cur;
                head.next = cur;
                size++;
            }

            private void pushBack(int val) {
                Node cur = new Node(val);
                cur.prev = tail.prev;
                cur.next = tail;
                tail.prev.next = cur;
                tail.prev = cur;
                size++;
            }

            private int popFront() {
                if (isEmpty()) {
                    return -1;
                }
                Node cur = head.next;
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
                size--;
                return cur.val;
            }

            private int popBack() {
                if (isEmpty()) {
                    return -1;
                }
                Node cur = tail.prev;
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
                size--;
                return cur.val;
            }

            private boolean isEmpty() {
                return size == 0;
            }

            private boolean isNotEmpty() {
                return !isEmpty();
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
