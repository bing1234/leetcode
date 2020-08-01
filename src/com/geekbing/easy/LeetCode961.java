package com.geekbing.easy;

import java.util.Random;

/**
 * @author bing
 */
public class LeetCode961 {
    public int repeatedNTimes(int[] A) {
        Random random = new Random();
        int random1, random2;
        while (true) {
            random1 = random.nextInt(A.length);
            random2 = random.nextInt(A.length);
            if (random1 != random2 && A[random1] == A[random2]) {
                return A[random1];
            }
        }
    }

    public static void main(String[] args) {
        LeetCode961 leetCode961 = new LeetCode961();
        System.out.println(leetCode961.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(leetCode961.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(leetCode961.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
        System.out.println(leetCode961.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
    }
}
