package com.geekbing.offer;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        return s.substring(n) + s.substring(0, n);
    }

    @Test
    public void testCase1() {
        Offer58II offer58II = new Offer58II();
        assert offer58II.reverseLeftWords("abcdefg", 2).equals("cdefgab");
    }

    @Test
    public void testCase2() {
        Offer58II offer58II = new Offer58II();
        assert offer58II.reverseLeftWords("lrloseumgh", 6).equals("umghlrlose");
    }
}
