package com.geekbing;

import java.util.List;

/**
 * @author bing
 */
public class LeetCode385 {
    public NestedInteger deserialize(String s) {
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            // 是否是负数
            boolean negative = false;
            switch (c) {
                case '[':
                    idx++;
                    break;
                case ']':
                    idx++;
                    break;
                case '-':
                    negative = true;
                    idx++;
                    break;
                case ',':
                    idx++;
                    break;
                default:
                    int num = 0;
                    while (idx < s.length() && '0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
                        num = num * 10 + s.charAt(idx) - '0';
                        idx++;
                    }
                    if (negative) {
                        num = -num;
                    }
                    // todo

                    negative = false;
                    idx++;
                    break;
            }
        }
        return null;
    }

    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        NestedInteger NestedInteger();

        // Constructor initializes a single integer.
        NestedInteger NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
