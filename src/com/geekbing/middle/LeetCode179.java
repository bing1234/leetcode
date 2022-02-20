package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode179 {
    public String largestNumber(int[] nums) {
        int cnt = (int) Arrays.stream(nums).filter(n -> n != 0).count();
        if (cnt == 0) {
            return "0";
        }
        return Arrays.stream(nums).boxed().map(String::valueOf).sorted(this::compare).reduce("", String::concat);
    }

    public int compare(String o1, String o2) {
        int idx = 0;
        while (idx < o1.length() && idx < o2.length()) {
            char char1 = o1.charAt(idx);
            char char2 = o2.charAt(idx);
            if (char1 > char2) {
                return -1;
            } else if (char1 == char2) {
                idx++;
            } else {
                return 1;
            }
        }
        if (idx < o1.length()) {
            return compare(o1.substring(idx), o2);
        }
        if (idx < o2.length()) {
            return compare(o1, o2.substring(idx));
        }
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode179 leetCode179 = new LeetCode179();
        String ans = leetCode179.largestNumber(new int[]{10, 2});
        assert ans.equals("210");
    }

    @Test
    public void testCase2() {
        LeetCode179 leetCode179 = new LeetCode179();
        String ans = leetCode179.largestNumber(new int[]{3, 30, 34, 5, 9});
        assert ans.equals("9534330");
    }

    @Test
    public void testCase3() {
        LeetCode179 leetCode179 = new LeetCode179();
        String ans = leetCode179.largestNumber(new int[]{0, 0});
        assert ans.equals("0");
    }
}
