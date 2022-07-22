package com.geekbing.lcp;

/**
 * @author bing
 */
public class Lcp17 {
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
        Lcp17 lcp17 = new Lcp17();
        System.out.println(lcp17.calculate("AB"));
    }
}
