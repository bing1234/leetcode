package com.geekbing.middle;

import java.util.HashMap;
import java.util.Map;

public class LeetCode146 {
    private static class LRUCache {
        // map用于存储key，value（指向双向链表的节点）
        private final Map<Integer, ListNode> map;
        // 存储value的双向链表
        private final ListNode head, tail;
        // 容量
        private final int capacity;

        public LRUCache(int capacity) {
            // 初始化map
            map = new HashMap<>();

            // 初始化头结点和尾结点（哑结点）
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.pre = head;

            // 容量
            this.capacity = capacity;
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if (node == null) {
                return -1;
            }

            // 将node移动到双向链表头部
            moveNodeToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            ListNode node = map.get(key);
            if (node == null) {
                node = new ListNode(key, value);
                // 在双向链表头部插入新节点
                insertNodeToHead(node);
                // map中建立key,node的关系
                map.put(key, node);
            } else {
                // 更新值
                node.val = value;

                // 将node移动到双向链表头部
                moveNodeToHead(node);
            }
        }

        private void moveNodeToHead(ListNode node) {
            // 将该节点从原来的双向链表中断开
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;

            // 将node节点插入头结点head之后
            insertNewNodeToHead(node);
        }

        private void insertNodeToHead(ListNode node) {
            if (capacity <= 0) {
                return;
            }
            // 先判断容量是否满了
            if (map.size() == capacity) {
                // 删除最后一个节点
                ListNode deleteNode = tail.pre;
                ListNode pre = deleteNode.pre;
                pre.next = tail;
                tail.pre = pre;

                // 删除map的key
                map.remove(deleteNode.key);
            }

            // 插入节点到头结点
            insertNewNodeToHead(node);
        }

        private void insertNewNodeToHead(ListNode node) {
            // 将新的node节点插入头结点head之后
            ListNode headNext = head.next;

            head.next = node;
            node.pre = head;

            node.next = headNext;
            headNext.pre = node;
        }

        private static class ListNode {
            private final int key;
            private int val;
            private ListNode pre;
            private ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
