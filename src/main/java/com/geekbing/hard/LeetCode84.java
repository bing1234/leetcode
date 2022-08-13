package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);

        int ans = 0;

        // 单调栈保存下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.empty() && newHeight[i] < newHeight[stack.peek()]) {
                // 栈顶元素下标
                int popIdx = stack.pop();
                // 栈顶元素高度
                int height = newHeight[popIdx];
                // 以栈顶元素为最低高度的矩形最大宽度（左右两边都比栈顶元素高度低）
                int width = i - stack.peek() - 1;

                // 计算矩形面积
                ans = Math.max(ans, width * height);
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode84 leetCode84 = new LeetCode84();
        int ans = leetCode84.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        assert ans == 10;
    }

    @Test
    public void testCase2() {
        LeetCode84 leetCode84 = new LeetCode84();
        int ans = leetCode84.largestRectangleArea(new int[]{2, 4});
        assert ans == 4;
    }
}
