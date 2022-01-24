package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author bing
 */
public class LeetCode1559 {
    public boolean containsCycle(char[][] grid) {
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode1559 leetCode1559 = new LeetCode1559();
        char[][] grid = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
        assert leetCode1559.containsCycle(grid);
    }

    @Test
    public void testCase2() {
        LeetCode1559 leetCode1559 = new LeetCode1559();
        char[][] grid = {{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}};
        assert leetCode1559.containsCycle(grid);
    }

    @Test
    public void testCase3() {
        LeetCode1559 leetCode1559 = new LeetCode1559();
        char[][] grid = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};
        assert !leetCode1559.containsCycle(grid);
    }
}
