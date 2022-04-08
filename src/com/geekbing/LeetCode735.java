package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) {
            return asteroids;
        }
        List<Integer> ans = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                int top = stack.peek();
                if ((top > 0 && asteroids[i] > 0) || (top < 0 && asteroids[i] < 0)) {
                    stack.push(asteroids[i]);
                } else if (top > 0 && asteroids[i] < 0) {

                } else if (top < 0 && asteroids[i] > 0) {

                }
            }
        }
        return new int[]{};
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
        int[] ans = leetCode735.asteroidCollision(new int[]{});
        assert Arrays.equals(ans, new int[]{10, 2, -5});
    }
}
