package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1860 {
    public int[] memLeak(int memory1, int memory2) {
        int need = 1;
        while (memory1 >= need || memory2 >= need) {
            if (memory1 >= memory2) {
                memory1 -= need;
            } else {
                memory2 -= need;
            }
            need++;
        }
        return new int[]{need, memory1, memory2};
    }

    public static void main(String[] args) {
        LeetCode1860 leetCode1860 = new LeetCode1860();

        System.out.println(Arrays.toString(leetCode1860.memLeak(2, 2)));
        System.out.println(Arrays.toString(leetCode1860.memLeak(8, 11)));
    }
}
