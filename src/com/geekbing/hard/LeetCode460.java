package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode460 {
    private static class LFUCache {

        public LFUCache(int capacity) {

        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {

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
}
