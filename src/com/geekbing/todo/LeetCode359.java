package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode359 {
    private static class Logger {

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            return true;
        }
    }

    @Test
    public void testCase1() {
        Logger logger = new Logger();
        assert logger.shouldPrintMessage(1, "foo");     // 返回 true ，下一次 "foo" 可以打印的时间戳是 1 + 10 = 11
        assert logger.shouldPrintMessage(2, "bar");     // 返回 true ，下一次 "bar" 可以打印的时间戳是 2 + 10 = 12
        assert !logger.shouldPrintMessage(3, "foo");    // 3 < 11 ，返回 false
        assert !logger.shouldPrintMessage(8, "bar");    // 8 < 12 ，返回 false
        assert !logger.shouldPrintMessage(10, "foo");   // 10 < 11 ，返回 false
        assert logger.shouldPrintMessage(11, "foo");    // 11 >= 11 ，返回 true ，下一次 "foo" 可以打印的时间戳是 11 + 10 = 21
    }
}
