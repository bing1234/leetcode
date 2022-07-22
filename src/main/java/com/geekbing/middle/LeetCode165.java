package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode165 {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int idx = 0;
        while (idx < arr1.length && idx < arr2.length) {
            int ans = Integer.compare(Integer.parseInt(arr1[idx]), Integer.parseInt(arr2[idx]));
            if (ans != 0) {
                return ans;
            }
            idx++;
        }
        if (idx == arr1.length && idx == arr2.length) {
            return 0;
        }
        if (idx == arr1.length) {
            for (int i = idx; i < arr2.length; i++) {
                if (Integer.parseInt(arr2[i]) != 0) {
                    return -1;
                }
            }
        }
        if (idx == arr2.length) {
            for (int i = idx; i < arr1.length; i++) {
                if (Integer.parseInt(arr1[i]) != 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode165 leetCode165 = new LeetCode165();
        assert leetCode165.compareVersion("1.01", "1.001") == 0;
    }

    @Test
    public void testCase2() {
        LeetCode165 leetCode165 = new LeetCode165();
        assert leetCode165.compareVersion("1.0", "1.0.0") == 0;
    }

    @Test
    public void testCase3() {
        LeetCode165 leetCode165 = new LeetCode165();
        assert leetCode165.compareVersion("0.1", "1.1") == -1;
    }
}
