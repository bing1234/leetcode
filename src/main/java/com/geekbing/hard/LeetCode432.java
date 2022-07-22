package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode432 {
    private static class AllOne {
        /**
         * 保存key-Node的对应关系
         */
        private final Map<String, Node> map;
        /**
         * 头节点为虚节点(越朝头节点方向cnt越大)
         */
        private final Node head;
        /**
         * 尾结点为虚节点(越朝尾节点方向cnt越小)
         */
        private final Node tail;

        public AllOne() {
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void inc(String key) {
            if (map.containsKey(key)) {
                // key在链表中存在
                Node cur = map.get(key);
                Node prev = cur.prev;
                if (prev == head || prev.cnt > cur.cnt + 1) {
                    // 需要新增一个节点
                    map.put(key, prev.insert(new Node(key, cur.cnt + 1)));
                } else {
                    prev.keys.add(key);
                    map.put(key, prev);
                }
                cur.keys.remove(key);
                if (cur.keys.isEmpty()) {
                    cur.remove();
                }
            } else {
                // key在链表中不存在
                if (tail.prev == head || tail.prev.cnt > 1) {
                    // 需要新增一个节点
                    map.put(key, tail.prev.insert(new Node(key, 1)));
                } else {
                    tail.prev.keys.add(key);
                    map.put(key, tail.prev);
                }
            }
        }

        public void dec(String key) {
            if (!map.containsKey(key)) {
                return;
            }
            Node cur = map.get(key);
            if (cur.cnt == 1) {
                map.remove(key);
            } else {
                Node next = cur.next;
                if (next == tail || next.cnt < cur.cnt - 1) {
                    // 需要新插入节点
                    map.put(key, cur.insert(new Node(key, cur.cnt - 1)));
                } else {
                    next.keys.add(key);
                    map.put(key, next);
                }
            }
            cur.keys.remove(key);
            if (cur.keys.isEmpty()) {
                cur.remove();
            }
        }

        public String getMaxKey() {
            if (head.next == tail) {
                return "";
            }
            return head.next.keys.iterator().next();
        }

        public String getMinKey() {
            if (tail.prev == head) {
                return "";
            }
            return tail.prev.keys.iterator().next();
        }

        private static class Node {
            private Node prev;
            private Node next;
            private Set<String> keys;
            private int cnt;

            public Node() {
            }

            public Node(String key, int cnt) {
                this.cnt = cnt;
                keys = new HashSet<>();
                keys.add(key);
            }

            private void remove() {
                this.prev.next = this.next;
                this.next.prev = this.prev;
            }

            private Node insert(Node node) {
                node.prev = this;
                node.next = this.next;
                this.next.prev = node;
                this.next = node;
                return node;
            }
        }
    }


    @Test
    public void testCase1() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        assert "hello".equals(allOne.getMaxKey()); // 返回 "hello"
        assert "hello".equals(allOne.getMinKey()); // 返回 "hello"
        allOne.inc("leet");
        assert "hello".equals(allOne.getMaxKey()); // 返回 "hello"
        assert "leet".equals(allOne.getMinKey()); // 返回 "leet"
        allOne.dec("hello");
    }
}
