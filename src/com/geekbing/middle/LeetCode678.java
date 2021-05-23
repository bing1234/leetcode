package com.geekbing.middle;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode678 {
    public boolean checkValidString(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        return false;
    }

    public static void main(String[] args) {
        LeetCode678 leetCode678 = new LeetCode678();
        System.out.println(leetCode678.checkValidString("()"));
        System.out.println(leetCode678.checkValidString("(*)"));
        System.out.println(leetCode678.checkValidString("(*))"));
    }
}
