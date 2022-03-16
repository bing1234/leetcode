package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode460 {
    private static class LFUCache {
        /**
         * 用于存储key - 指向双向链表的节点
         */
        private final Map<Integer, Node> cache;

        /**
         * 双向链表头节点为虚节点(越朝头节点方向cnt越大)
         */
        private final Node head;

        /**
         * 双向链表尾结点为虚节点(越朝头节点方向cnt越小)
         */
        private final Node tail;

        /**
         * 容量
         */
        private final int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            Node cur = cache.get(key);
            int value = cur.map.get(key);
            Node prev = cur.prev;
            if (prev == head || prev.cnt > cur.cnt + 1) {
                // 需要新增节点
                cache.put(key, prev.insert(new Node(key, value, cur.cnt + 1)));
            } else {
                prev.map.put(key, value);
                cache.put(key, prev);
            }
            cur.map.remove(key);
            if (cur.map.isEmpty()) {
                cur.remove();
            }
            return value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!cache.containsKey(key) && cache.size() == capacity) {
                // 容量达到上限后，写入新数据的话需要先移除最不经常使用的项
                if (tail.prev != head) {
                    Integer delKey = tail.prev.map.keySet().iterator().next();
                    tail.prev.map.remove(delKey);
                    if (tail.prev.map.isEmpty()) {
                        tail.prev.remove();
                    }
                    cache.remove(delKey);
                }
            }
            if (cache.containsKey(key)) {
                Node cur = cache.get(key);
                Node prev = cur.prev;
                if (prev == head || prev.cnt > cur.cnt + 1) {
                    // 需要新增节点
                    cache.put(key, prev.insert(new Node(key, value, cur.cnt + 1)));
                } else {
                    prev.map.put(key, value);
                    cache.put(key, prev);
                }
                cur.map.remove(key);
                if (cur.map.isEmpty()) {
                    cur.remove();
                }
            } else {
                if (tail.prev == head || tail.prev.cnt > 1) {
                    // 需要新增节点
                    cache.put(key, tail.prev.insert(new Node(key, value, 1)));
                } else {
                    tail.prev.map.put(key, value);
                    cache.put(key, tail.prev);
                }
            }
        }

        private static class Node {
            private Node prev;
            private Node next;
            private Map<Integer, Integer> map;
            private int cnt;

            public Node() {
            }

            public Node(int key, int val, int cnt) {
                map = new LinkedHashMap<>();
                map.put(key, val);
                this.cnt = cnt;
            }

            private Node insert(Node node) {
                node.prev = this;
                node.next = this.next;
                this.next.prev = node;
                this.next = node;
                return node;
            }

            private void remove() {
                this.prev.next = this.next;
                this.next.prev = this.prev;
            }
        }
    }

    @Test
    public void testCase1() {
        // cnt(x) = 键 x 的使用计数
        // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        assert lfu.get(1) == 1;      // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        assert lfu.get(2) == -1;      // 返回 -1（未找到）
        assert lfu.get(3) == 3;      // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        assert lfu.get(1) == -1;      // 返回 -1（未找到）
        assert lfu.get(3) == 3;      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        assert lfu.get(4) == 4;      // 返回 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
    }

    @Test
    public void testCase2() {
        //        ["LFUCache","get",    "put",   "get",     "put",      "put",      "get",      "get"]
//                [[2],        [2],     [2,6],   [1],       [1,5],      [1,2],      [1],        [2]]
//               [null,        -1,      null,    -1,        null,       null,       2,          6]
        LFUCache lfu = new LFUCache(2);
        assert lfu.get(2) == -1;
        lfu.put(2, 6);
        assert lfu.get(1) == -1;
        lfu.put(1, 5);
        lfu.put(1, 2);
        assert lfu.get(1) == 2;
        assert lfu.get(2) == 6;
    }
}
