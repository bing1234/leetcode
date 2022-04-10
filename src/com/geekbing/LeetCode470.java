package com.geekbing;

import java.util.Random;

/**
 * @author bing
 */
public class LeetCode470 {
    private static class SolBase {
        private final Random random = new Random();

        public int rand7() {
            return random.nextInt(8);
        }
    }

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    private static class Solution extends SolBase {
        public int rand10() {
            return 0;
        }
    }
}
