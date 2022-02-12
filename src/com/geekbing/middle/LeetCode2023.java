package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2023 {
    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]).equals(target)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2023 leetCode2023 = new LeetCode2023();
        assert leetCode2023.numOfPairs(new String[]{"777", "7", "77", "77"}, "7777") == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2023 leetCode2023 = new LeetCode2023();
        assert leetCode2023.numOfPairs(new String[]{"123", "4", "12", "34"}, "1234") == 2;
    }

    @Test
    public void testCase3() {
        LeetCode2023 leetCode2023 = new LeetCode2023();
        assert leetCode2023.numOfPairs(new String[]{"1", "1", "1"}, "11") == 6;
    }
}
