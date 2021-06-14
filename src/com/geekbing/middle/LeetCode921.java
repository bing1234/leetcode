package com.geekbing.middle;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode921 {
    public int minAddToMakeValid(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty()) {
                char c = stack.peek();
                if (c == '(' && chars[i] == ')') {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        LeetCode921 leetCode921 = new LeetCode921();

        System.out.println(leetCode921.minAddToMakeValid("())"));
        System.out.println(leetCode921.minAddToMakeValid("((("));
        System.out.println(leetCode921.minAddToMakeValid("()"));
        System.out.println(leetCode921.minAddToMakeValid("()))(("));
    }
}
