package com.geekbing.offer;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class Offer58I {
    public String reverseWords(String s) {
        return "";
    }

    @Test
    public void testCase1() {
        Offer58I offer58I = new Offer58I();
        assert offer58I.reverseWords("the sky is blue").equals("blue is sky the");
    }

    @Test
    public void testCase2() {
        Offer58I offer58I = new Offer58I();
        assert offer58I.reverseWords("  hello world!  ").equals("world! hello");
    }

    @Test
    public void testCase3() {
        Offer58I offer58I = new Offer58I();
        assert offer58I.reverseWords("a good   example").equals("example good a");
    }
}
