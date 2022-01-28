package com.geekbing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2103 {
    public int countPoints(String rings) {
        int[] bucket = new int[10];
        char[] chars = rings.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            int key = chars[i + 1] - '0';
            int val = bucket[key];
            switch (chars[i]) {
                case 'R':
                    val = val | 4;
                    break;
                case 'G':
                    val = val | 2;
                    break;
                default:
                    val = val | 1;
                    break;
            }
            bucket[key] = val;
        }
        return (int) Arrays.stream(bucket).filter(v -> v == 7).count();
    }

    @Test
    public void testCase1() {
        LeetCode2103 leetCode2103 = new LeetCode2103();
        assert leetCode2103.countPoints("B0B6G0R6R0R6G9") == 1;
    }

    @Test
    public void testCase2() {
        LeetCode2103 leetCode2103 = new LeetCode2103();
        assert leetCode2103.countPoints("B0R0G0R9R0B0G0") == 1;
    }

    @Test
    public void testCase3() {
        LeetCode2103 leetCode2103 = new LeetCode2103();
        assert leetCode2103.countPoints("G4") == 0;
    }
}
