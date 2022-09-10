package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode2399 {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Pair pair = map.get(c);
            if (pair == null) {
                pair = new Pair();
                pair.setFirst(i);
            } else {
                pair.setSecond(i);
            }
            map.put(c, pair);
        }
        for (int i = 0; i < distance.length; i++) {
            char c = (char) ('a' + i);
            Pair pair = map.get(c);
            if (pair == null) {
                continue;
            }
            if (pair.getSecond() - pair.getFirst() - 1 != distance[i]) {
                return false;
            }
        }
        return true;
    }

    private static class Pair {
        private int first;
        private int second;

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2399 leetCode2399 = new LeetCode2399();
        assert leetCode2399.checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    @Test
    public void testCase2() {
        LeetCode2399 leetCode2399 = new LeetCode2399();
        assert !leetCode2399.checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }
}
