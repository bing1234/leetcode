package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode707 {
    private static class MyLinkedList {
        /**
         * 双向链表的头结点为虚节点
         */
        private final ListNode head;

        /**
         * 双向链表的尾结点为虚节点
         */
        private final ListNode tail;

        /**
         * 双向链表的长度
         */
        private int size;

        public MyLinkedList() {
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            ListNode cur = getListNode(index);
            return cur.val;
        }

        private ListNode getListNode(int index) {
            if (index <= size / 2) {
                // 从头开始超尾遍历
                ListNode idx = head.next;
                for (int i = 0; i < index; i++) {
                    idx = idx.next;
                }
                return idx;
            } else {
                // 从尾超前开始遍历
                ListNode idx = tail.prev;
                for (int i = 0; i < size - index - 1; i++) {
                    idx = idx.prev;
                }
                return idx;
            }
        }

        public void addAtHead(int val) {
            ListNode cur = new ListNode(val);
            cur.next = head.next;
            cur.prev = head;
            head.next.prev = cur;
            head.next = cur;
            size++;
        }

        public void addAtTail(int val) {
            ListNode cur = new ListNode(val);
            cur.next = tail;
            cur.prev = tail.prev;
            tail.prev.next = cur;
            tail.prev = cur;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
            } else if (index < 0) {
                addAtHead(val);
            } else {
                ListNode prev = getListNode(index).prev;
                ListNode cur = new ListNode(val);
                cur.next = prev.next;
                cur.prev = prev;
                prev.next.prev = cur;
                prev.next = cur;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode cur = getListNode(index);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }

        private static class ListNode {
            private ListNode prev;
            private ListNode next;
            private int val;

            public ListNode() {
            }

            public ListNode(int val) {
                this.val = val;
            }
        }
    }

    @Test
    public void testCase1() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);    //链表变为1-> 2-> 3
        assert linkedList.get(1) == 2;            //返回2
        linkedList.deleteAtIndex(1);              //现在链表是1-> 3
        assert linkedList.get(1) == 3;            //返回3
    }

    @Test
    public void testCase2() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0, 10);
        linkedList.addAtIndex(0, 20);
        linkedList.addAtIndex(1, 30);
        assert linkedList.get(0) == 20;
    }
}
