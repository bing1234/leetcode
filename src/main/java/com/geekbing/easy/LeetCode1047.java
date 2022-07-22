package com.geekbing.easy;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode1047 leetCode1047 = new LeetCode1047();
        System.out.println(leetCode1047.removeDuplicates("abbaca"));
    }
}
