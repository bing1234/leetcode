package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author bing
 */
public class LeetCode284 {
    private static class PeekingIterator implements Iterator<Integer> {
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return 0;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return 0;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }

    @Test
    public void testCase1() {
        PeekingIterator peekingIterator = new PeekingIterator(new ArrayList<>(Arrays.asList(1, 2, 3)).iterator()); // [1,2,3]
        assert peekingIterator.next() == 1;    // 返回 1 ，指针移动到下一个元素 [1,2,3]
        assert peekingIterator.peek() == 2;    // 返回 2 ，指针未发生移动 [1,2,3]
        assert peekingIterator.next() == 2;    // 返回 2 ，指针移动到下一个元素 [1,2,3]
        assert peekingIterator.next() == 3;    // 返回 3 ，指针移动到下一个元素 [1,2,3]
        assert !peekingIterator.hasNext(); // 返回 False
    }
}
