package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode981 {
    private static class TimeMap {

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {

        }

        public String get(String key, int timestamp) {

        }
    }

    @Test
    public void testCase1(){
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);         // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1  
        assert timeMap.get("foo", 1).equals("bar"); // 返回 "bar"
        assert timeMap.get("foo", 3).equals("bar"); // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
        timeMap.set("foo", "bar2", 4);        // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4 
        assert timeMap.get("foo", 4).equals("bar2");// 返回 "bar2"
        assert timeMap.get("foo", 5).equals("bar2");// 返回 "bar2"
    }
}
