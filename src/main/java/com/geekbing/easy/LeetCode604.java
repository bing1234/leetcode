package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode604 {
    private static class StringIterator {
        private final String str;
        private final int len;
        private int idx;
        private char cur;
        private int curNum;

        public StringIterator(String compressedString) {
            str = compressedString;
            len = str.length();
            idx = 0;
            cur = str.charAt(idx++);
            curNum = 0;
            while (idx < len && Character.isDigit(str.charAt(idx))) {
                curNum = curNum * 10 + (str.charAt(idx++) - '0');
            }
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            if (curNum == 0) {
                cur = str.charAt(idx++);
                while (idx < len && Character.isDigit(str.charAt(idx))) {
                    curNum = curNum * 10 + (str.charAt(idx++) - '0');
                }
            }
            curNum--;
            return cur;
        }

        public boolean hasNext() {
            return idx != len || curNum != 0;
        }
    }

    @Test
    public void testCase1() {
        StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
        assert stringIterator.next() == 'L'; // 返回 "L"
        assert stringIterator.next() == 'e'; // 返回 "e"
        assert stringIterator.next() == 'e'; // 返回 "e"
        assert stringIterator.next() == 't'; // 返回 "t"
        assert stringIterator.next() == 'C'; // 返回 "C"
        assert stringIterator.next() == 'o'; // 返回 "o"
        assert stringIterator.hasNext(); // 返回 True
        assert stringIterator.next() == 'd'; // 返回 "d"
        assert stringIterator.hasNext(); // 返回 True
    }
}
