package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/***
 * @author bing
 */
public class LeetCode1399 {
    public int countLargestGroup(int n) {
        int[] counts = new int[36];
        for (int i = 1; i <= n; i++) {
            counts[calBitSum(i)]++;
        }
        int max = Integer.MIN_VALUE, count = 0;
        for (int num : counts) {
            if (num == 0) {
                continue;
            }
            if (max < num) {
                max = num;
                count = 1;
            } else if (num == max) {
                count++;
            }
        }
        return count;
    }

    private int calBitSum(int num) {
        int sum = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }

    @Test
    public void testCase1() {
        LeetCode1399 leetCode1399 = new LeetCode1399();
        assert leetCode1399.countLargestGroup(13) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode1399 leetCode1399 = new LeetCode1399();
        assert leetCode1399.countLargestGroup(2) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode1399 leetCode1399 = new LeetCode1399();
        assert leetCode1399.countLargestGroup(15) == 6;
    }

    @Test
    public void testCase4() {
        LeetCode1399 leetCode1399 = new LeetCode1399();
        assert leetCode1399.countLargestGroup(24) == 5;
    }
}
