package com.geekbing.lcp;

/**
 * @author bing
 */
public class Lcp01 {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Lcp01 lcp01 = new Lcp01();
        System.out.println(lcp01.game(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(lcp01.game(new int[]{2, 2, 3}, new int[]{3, 2, 1}));
    }
}
