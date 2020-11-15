package com.geekbing.middle;

import java.util.Stack;

public class LeetCode402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int cur = Integer.parseInt(String.valueOf(c));
            if (stack.isEmpty()) {
                if (cur != 0) {
                    stack.push(cur);
                }
            } else {
                if (k == 0) {
                    stack.push(cur);
                } else {
                    while (k > 0 && !stack.isEmpty() && cur < stack.peek()) {
                        stack.pop();
                        k--;
                    }
                    if (cur == 0 && stack.isEmpty()) {
                        continue;
                    }
                    stack.push(cur);
                }
            }
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode402 leetCode402 = new LeetCode402();
//        System.out.println(leetCode402.removeKdigits("1432219", 3));
//        System.out.println(leetCode402.removeKdigits("10200", 1));
//        System.out.println(leetCode402.removeKdigits("10", 2));
        System.out.println(leetCode402.removeKdigits("9", 1));
    }
}
