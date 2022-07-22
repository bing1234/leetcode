package com.geekbing.middle;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/submissions/
 * 71. 简化路径
 *
 * @author bing
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] items = path.split("/");
        for (String item : items) {
            if ("".equals(item) || ".".equals(item) || "/".equals(item)) {
                continue;
            }
            if ("src/main".equals(item)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(item);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder ans = new StringBuilder(stack.pop());
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop() + "/");
        }
        return "/" + ans;
    }

    public static void main(String[] args) {
        LeetCode71 leetCode71 = new LeetCode71();
        System.out.println(leetCode71.simplifyPath("/home/"));
        System.out.println(leetCode71.simplifyPath("/../"));
        System.out.println(leetCode71.simplifyPath("/home//foo/"));
        System.out.println(leetCode71.simplifyPath("/a/./b/../../c/"));
        System.out.println(leetCode71.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(leetCode71.simplifyPath("/a//b////c/d//././/.."));
    }
}
