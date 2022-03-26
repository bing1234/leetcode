package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode981 {
    private static class TimeMap {
        private final Map<String, List<Pair>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Pair> pairs = map.get(key);
            if (pairs == null || pairs.isEmpty()) {
                pairs = new ArrayList<>();
            }
            pairs.add(new Pair(timestamp, value));
            map.put(key, pairs);
        }

        public String get(String key, int timestamp) {
            List<Pair> pairs = map.get(key);
            if (pairs == null || pairs.isEmpty()) {
                return "";
            }
            // 二分查找
            return binarySearch(pairs, timestamp);
        }

        private String binarySearch(List<Pair> pairs, int timestamp) {
            int left = 0, right = pairs.size() - 1;
            if (pairs.get(left).timestamp > timestamp) {
                return "";
            }
            if (pairs.get(right).timestamp <= timestamp) {
                return pairs.get(right).val;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                Pair pair = pairs.get(mid);
                if (pair.timestamp < timestamp) {
                    left = mid + 1;
                } else if (pair.timestamp == timestamp) {
                    return pair.val;
                } else {
                    right = mid;
                }
            }
            if (left - 1 >= 0) {
                return pairs.get(left - 1).val;
            }
            return "";
        }

        private static class Pair {
            private int timestamp;
            private String val;

            public Pair(int timestamp, String val) {
                this.timestamp = timestamp;
                this.val = val;
            }
        }
    }

    @Test
    public void testCase1() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);         // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
        assert timeMap.get("foo", 1).equals("bar"); // 返回 "bar"
        assert timeMap.get("foo", 3).equals("bar"); // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
        timeMap.set("foo", "bar2", 4);        // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
        assert timeMap.get("foo", 4).equals("bar2");// 返回 "bar2"
        assert timeMap.get("foo", 5).equals("bar2");// 返回 "bar2"
    }

    @Test
    public void testCase2() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        assert timeMap.get("love", 5).equals("");
        assert timeMap.get("love", 10).equals("high");
        assert timeMap.get("love", 15).equals("high");
        assert timeMap.get("love", 20).equals("low");
        assert timeMap.get("love", 25).equals("low");
    }
}
