package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, ans = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                ans++;
            } else {
                right--;
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode881 leetCode881 = new LeetCode881();
        assert leetCode881.numRescueBoats(new int[]{1, 2}, 3) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode881 leetCode881 = new LeetCode881();
        assert leetCode881.numRescueBoats(new int[]{3, 2, 2, 1}, 3) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode881 leetCode881 = new LeetCode881();
        assert leetCode881.numRescueBoats(new int[]{3, 5, 3, 4}, 5) == 4;
    }
}
