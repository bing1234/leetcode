package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2169 {
    public int countOperationsV2(int num1, int num2) {
        int ans = 0;
        while (num1 != 0 && num2 != 0) {
            ans += num1 / num2;
            num1 = num1 % num2;

            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        return ans;
    }

    public int countOperations(int num1, int num2) {
        int ans = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            ans++;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2169 leetCode2169 = new LeetCode2169();
        assert leetCode2169.countOperations(2, 3) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2169 leetCode2169 = new LeetCode2169();
        assert leetCode2169.countOperations(10, 10) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode2169 leetCode2169 = new LeetCode2169();
        assert leetCode2169.countOperationsV2(2, 3) == 3;
    }

    @Test
    public void testCase4() {
        LeetCode2169 leetCode2169 = new LeetCode2169();
        assert leetCode2169.countOperationsV2(10, 10) == 1;
    }
}
