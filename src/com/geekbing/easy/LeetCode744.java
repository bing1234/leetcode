package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left];
    }

    @Test
    public void testCase1() {
        LeetCode744 leetCode744 = new LeetCode744();
        assert leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a') == 'c';
    }

    @Test
    public void testCase2() {
        LeetCode744 leetCode744 = new LeetCode744();
        assert leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c') == 'f';
    }

    @Test
    public void testCase3() {
        LeetCode744 leetCode744 = new LeetCode744();
        assert leetCode744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd') == 'f';
    }
}
