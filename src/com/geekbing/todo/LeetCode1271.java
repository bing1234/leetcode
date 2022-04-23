package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1271 {
    public String toHexspeak(String num) {
        return "";
    }

    @Test
    public void testCase1(){
        LeetCode1271 leetCode1271 = new LeetCode1271();
        assert leetCode1271.toHexspeak("257").equals("IOI");
    }

    @Test
    public void testCase2(){
        LeetCode1271 leetCode1271 = new LeetCode1271();
        assert leetCode1271.toHexspeak("3").equals("ERROR");
    }
}
