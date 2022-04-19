package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1119 {
    public String removeVowels(String s) {
        return "";
    }

    @Test
    public void testCase1() {
        LeetCode1119 leetCode1119 = new LeetCode1119();
        assert leetCode1119.removeVowels("leetcodeisacommunityforcoders").equals("ltcdscmmntyfrcdrs");
    }

    @Test
    public void testCase2() {
        LeetCode1119 leetCode1119 = new LeetCode1119();
        assert leetCode1119.removeVowels("aeiou").equals("");
    }
}
