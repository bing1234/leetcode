package com.geekbing.lcp;

import java.util.Arrays;

public class LCP02 {
    public int[] fraction(int[] cont) {
        if (cont.length == 0) {
            return new int[]{};
        }
        if (cont.length == 1) {
            return new int[]{cont[0], 1};
        }
        if (cont.length == 2) {
            return fractionTwo(cont[0], cont[1]);
        }
        int[] arr = fractionTwo(cont[cont.length - 2], cont[cont.length - 1]);
        for (int i = cont.length - 3; i >= 0; i--) {
            arr = fractionTwoThree(cont[i], arr[0], arr[1]);
        }
        return arr;
    }

    private int[] fractionTwo(int a, int b) {
        return new int[]{a * b + 1, b};
    }

    private int[] fractionTwoThree(int a, int b, int c) {
        return new int[]{a * b + c, b};
    }

    public static void main(String[] args) {
        LCP02 lcp02 = new LCP02();
        System.out.println(Arrays.toString(lcp02.fraction(new int[]{3, 2, 0, 2})));
        System.out.println(Arrays.toString(lcp02.fraction(new int[]{0, 0, 3})));
    }
}
