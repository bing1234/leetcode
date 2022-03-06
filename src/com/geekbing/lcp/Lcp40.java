package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class Lcp40 {
    public int maxmiumScore(int[] cards, int cnt) {
        if (cnt > cards.length) {
            return 0;
        }
        Arrays.sort(cards);

        // 最后cnt个数的和、最后cnt个数中最小的奇数、偶数
        int[] endArr = endSumOfCards(cards, cnt);
        int sum = endArr[0], endMinOdd = endArr[1], endMinEven = endArr[2];
        if (sum % 2 == 0) {
            return sum;
        }

        // 剩余最大的奇数和偶数
        int[] remainArr = remainMax(cards, cnt);
        int remainMaxOdd = remainArr[0], remainMaxEven = remainArr[1];
        if (remainMaxEven == Integer.MIN_VALUE && remainMaxOdd == Integer.MIN_VALUE) {
            return 0;
        }

        // 将最小的奇数与最大的偶数做替换、将最小的偶数与最大的奇数做替换
        boolean canReplaceEndMinOdd = endMinOdd != Integer.MAX_VALUE && remainMaxEven != Integer.MIN_VALUE;
        boolean canReplaceEndMinEven = endMinEven != Integer.MAX_VALUE && remainMaxOdd != Integer.MIN_VALUE;
        if (canReplaceEndMinOdd && canReplaceEndMinEven) {
            return Math.max(sum - endMinOdd + remainMaxEven, sum - endMinEven + remainMaxOdd);
        } else if (canReplaceEndMinOdd) {
            return sum - endMinOdd + remainMaxEven;
        } else if (canReplaceEndMinEven) {
            return sum - endMinEven + remainMaxOdd;
        } else {
            return 0;
        }
    }

    private int[] endSumOfCards(int[] cards, int cnt) {
        // 最后cnt个数的和、最后cnt个数中最小的奇数、偶数
        int sum = 0, endMinOdd = Integer.MAX_VALUE, endMinEven = Integer.MAX_VALUE;
        int end = cards.length - cnt;
        for (int i = cards.length - 1; i >= end; i--) {
            if (cards[i] % 2 == 0) {
                endMinEven = Math.min(endMinEven, cards[i]);
            } else {
                endMinOdd = Math.min(endMinOdd, cards[i]);
            }
            sum += cards[i];
        }
        return new int[]{sum, endMinOdd, endMinEven};
    }

    private int[] remainMax(int[] cards, int cnt) {
        int end = cards.length - cnt;
        // 剩余最大的奇数和偶数
        int remainMaxOdd = Integer.MIN_VALUE, remainMaxEven = Integer.MIN_VALUE;
        for (int i = end - 1; i >= 0; i--) {
            if (cards[i] % 2 == 0) {
                if (remainMaxEven == Integer.MIN_VALUE) {
                    remainMaxEven = cards[i];
                }
            } else {
                if (remainMaxOdd == Integer.MIN_VALUE) {
                    remainMaxOdd = cards[i];
                }
            }
            if (remainMaxOdd != Integer.MIN_VALUE && remainMaxEven != Integer.MIN_VALUE) {
                break;
            }
        }
        return new int[]{remainMaxOdd, remainMaxEven};
    }

    @Test
    public void testCase1() {
        Lcp40 lcp40 = new Lcp40();
        assert lcp40.maxmiumScore(new int[]{1, 2, 8, 9}, 3) == 18;
    }

    @Test
    public void testCase2() {
        Lcp40 lcp40 = new Lcp40();
        assert lcp40.maxmiumScore(new int[]{3, 3, 1}, 1) == 0;
    }

    @Test
    public void testCase3() {
        Lcp40 lcp40 = new Lcp40();
        assert lcp40.maxmiumScore(new int[]{9, 5, 9, 1, 6, 10, 3, 4, 5, 1}, 2) == 18;
    }

    @Test
    public void testCase4() {
        Lcp40 lcp40 = new Lcp40();
        assert lcp40.maxmiumScore(new int[]{7, 4, 1}, 1) == 4;
    }

    @Test
    public void testCase5() {
        Lcp40 lcp40 = new Lcp40();
        int[] cards = new int[]{3, 7, 9, 15, 11, 20, 3, 13, 14, 12, 17, 19, 12, 12, 2, 14, 4, 4, 16, 8, 3, 17, 13, 1, 11, 12, 19, 7, 7, 4, 12, 14, 19, 19, 19, 8, 6, 1, 15, 4, 7, 19, 5, 17, 2, 7, 5, 5, 9, 6, 3, 19, 11, 15, 8, 17, 3, 10, 1, 2, 4, 19, 9, 14, 6, 1, 19, 16, 7, 7, 7, 14, 11, 4, 10, 3, 19, 3, 9, 4, 6, 16, 8, 6, 13, 20, 17, 4};
        int ans = lcp40.maxmiumScore(cards, 40);
        System.out.println(ans);
    }
}
