package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2000 {
    public String reversePrefix(String word, char ch) {
        int left = 0, right = word.length();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                right = i;
                break;
            }
        }
        if (right == 0 || right == word.length()) {
            return word;
        }

        char[] arr = new char[right + 1];
        while (left <= right) {
            arr[left] = word.charAt(right);
            arr[right] = word.charAt(left);
            left++;
            right--;
        }
        return new String(arr) + word.substring(arr.length);
    }

    @Test
    public void testCase1() {
        LeetCode2000 leetCode2000 = new LeetCode2000();
        String ans = leetCode2000.reversePrefix("abcdefd", 'd');
        assert ans.equals("dcbaefd");
    }

    @Test
    public void testCase2() {
        LeetCode2000 leetCode2000 = new LeetCode2000();
        String ans = leetCode2000.reversePrefix("xyxzxe", 'z');
        assert ans.equals("zxyxxe");
    }

    @Test
    public void testCase3() {
        LeetCode2000 leetCode2000 = new LeetCode2000();
        String ans = leetCode2000.reversePrefix("abcd", 'z');
        assert ans.equals("abcd");
    }

    @Test
    public void testCase4() {
        LeetCode2000 leetCode2000 = new LeetCode2000();
        String ans = leetCode2000.reversePrefix("j", 'j');
        assert ans.equals("j");
    }

    @Test
    public void testCase5() {
        LeetCode2000 leetCode2000 = new LeetCode2000();
        String ans = leetCode2000.reversePrefix("lweefee", 'f');
        assert ans.equals("feewlee");
    }
}
