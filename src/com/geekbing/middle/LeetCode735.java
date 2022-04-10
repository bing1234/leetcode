package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                // 撞毁所有朝右且质量小于的星球
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode735 leetCode735 = new LeetCode735();
        int[] ans = leetCode735.asteroidCollision(new int[]{5, 10, -5});
        assert Arrays.equals(ans, new int[]{5, 10});
    }

    @Test
    public void testCase2() {
        LeetCode735 leetCode735 = new LeetCode735();
        int[] ans = leetCode735.asteroidCollision(new int[]{8, -8});
        assert Arrays.equals(ans, new int[]{});
    }

    @Test
    public void testCase3() {
        LeetCode735 leetCode735 = new LeetCode735();
        int[] ans = leetCode735.asteroidCollision(new int[]{10, 2, -5});
        assert Arrays.equals(ans, new int[]{10});
    }
}
