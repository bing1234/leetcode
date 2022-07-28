package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode2351 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                return c;
            }
            set.add(c);
        }
        return ' ';
    }

    @Test
    public void testCase1() {
        LeetCode2351 leetCode2351 = new LeetCode2351();
        assert leetCode2351.repeatedCharacter("abccbaacz") == 'c';
    }

    @Test
    public void testCase2() {
        LeetCode2351 leetCode2351 = new LeetCode2351();
        assert leetCode2351.repeatedCharacter("abcdd") == 'd';
    }
}

