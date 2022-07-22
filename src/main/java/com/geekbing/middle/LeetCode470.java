package com.geekbing.middle;

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
            int r = rand7();
            while (r == 7) {
                r = rand7();
            }
            r = r % 2;
            return rand5() + r * 5;
        }

        private int rand5() {
            int r = rand7();
            while (r > 5) {
                r = rand7();
            }
            return r;
        }
    }
}
