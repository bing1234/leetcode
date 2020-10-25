package com.geekbing.easy;

/**
 * 1614. 括号的最大嵌套深度
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 *
 * @author bing
 */
public class LeetCode1614 {
    public int maxDepth(String s) {
        int ans = 0, leftCnt = 0, rightCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCnt++;
                ans = Math.max(ans, leftCnt - rightCnt);
            } else if (c == ')') {
                leftCnt--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1614 leetCode1614 = new LeetCode1614();
        System.out.println(leetCode1614.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(leetCode1614.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(leetCode1614.maxDepth("1+(2*3)/(2-1)"));
        System.out.println(leetCode1614.maxDepth("1"));
    }
}
