package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author bing
 */
public class LeetCode1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert leetCode1361.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1});
    }

    @Test
    public void testCase2() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert !leetCode1361.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1});
    }

    @Test
    public void testCase3() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert !leetCode1361.validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1});
    }

    @Test
    public void testCase4() {
        LeetCode1361 leetCode1361 = new LeetCode1361();
        assert !leetCode1361.validateBinaryTreeNodes(6, new int[]{1, -1, -1, 4, -1, -1}, new int[]{2, -1, -1, 5, -1, -1});
    }
}
