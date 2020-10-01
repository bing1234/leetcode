package com.geekbing.lcp;

public class LCP17 {
    public int calculate(String s) {
        int x = 1, y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    public static void main(String[] args) {
        LCP17 lcp17 = new LCP17();
        System.out.println(lcp17.calculate("AB"));
    }
}
