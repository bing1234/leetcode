package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode341 {
    private static class NestedIterator implements Iterator<Integer> {
        private final List<Integer> values;
        private final Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            values = new ArrayList<>();
            travel(nestedList);
            iterator = values.iterator();
        }

        private void travel(List<NestedInteger> nestedList) {
            for (NestedInteger nested : nestedList) {
                if (nested.isInteger()) {
                    values.add(nested.getInteger());
                } else {
                    travel(nested.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
