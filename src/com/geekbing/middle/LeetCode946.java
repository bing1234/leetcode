package com.geekbing.middle;

import java.util.Stack;

public class LeetCode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[popIdx] == stack.peek()) {
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode946 leetCode946 = new LeetCode946();
        System.out.println(leetCode946.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(leetCode946.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
