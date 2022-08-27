package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int totalEnergy = Arrays.stream(energy).sum();
        int subSum = 0, needExperience = 0;
        for (int item : experience) {
            if (subSum <= item) {
                needExperience = Math.max(needExperience, item + 1 - subSum);
            }
            subSum += item;
        }
        if (initialEnergy > totalEnergy && initialExperience >= needExperience) {
            return 0;
        } else if (initialEnergy > totalEnergy) {
            return needExperience - initialExperience;
        } else if (initialExperience >= needExperience) {
            return totalEnergy + 1 - initialEnergy;
        } else {
            return totalEnergy + 1 - initialEnergy + needExperience - initialExperience;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int ans = leetCode2383.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1});
        assert ans == 8;
    }

    @Test
    public void testCase2() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int ans = leetCode2383.minNumberOfHours(2, 4, new int[]{1}, new int[]{3});
        assert ans == 0;
    }

    @Test
    public void testCase3() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int ans = leetCode2383.minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50});
        assert ans == 51;
    }

    @Test
    public void testCase4() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int[] energy = new int[]{58, 47, 100, 71, 47, 6, 92, 82, 35, 16, 50, 15, 42, 5, 2, 45, 22};
        int[] experience = new int[]{77, 83, 99, 76, 75, 66, 58, 84, 44, 98, 70, 41, 48, 7, 10, 61, 28};
        int ans = leetCode2383.minNumberOfHours(94, 70, energy, experience);
        assert ans == 650;
    }

    @Test
    public void testCase5() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int[] energy = new int[]{69, 22, 93, 68, 57, 76, 54, 72, 8, 78, 88, 15, 58, 61, 25, 70, 58, 91, 79, 22, 91, 74, 90, 75, 31, 53, 31, 7, 51, 96, 76, 17, 64, 89, 83, 54, 28, 33, 32, 45, 20};
        int[] experience = new int[]{51, 81, 46, 80, 56, 7, 46, 74, 64, 20, 84, 66, 13, 91, 49, 30, 75, 43, 74, 88, 82, 51, 72, 4, 80, 30, 10, 19, 40, 27, 21, 71, 24, 94, 79, 13, 40, 28, 63, 85, 70};
        int ans = leetCode2383.minNumberOfHours(11, 23, energy, experience);
        assert ans == 2323;
    }

    @Test
    public void testCase6() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int[] energy = new int[]{24, 91, 63, 38, 31, 63, 22, 35, 91, 54, 88, 46, 80, 14, 12, 19, 57, 92};
        int[] experience = new int[]{18, 43, 36, 88, 84, 21, 82, 54, 61, 80, 68, 54, 75, 27, 99, 14, 86, 95};
        int ans = leetCode2383.minNumberOfHours(30, 78, energy, experience);
        assert ans == 891;
    }
}
