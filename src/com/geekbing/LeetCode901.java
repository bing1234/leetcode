package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode901 {
    private static class StockSpanner {

        public StockSpanner() {

        }

        public int next(int price) {
            return 0;
        }
    }

    @Test
    public void testCase1() {
        StockSpanner S = new StockSpanner();
        assert S.next(100) == 1;
        assert S.next(80) == 1;
        assert S.next(60) == 1;
        assert S.next(70) == 2;
        assert S.next(60) == 1;
        assert S.next(75) == 4;
        assert S.next(85) == 6;
    }
}
