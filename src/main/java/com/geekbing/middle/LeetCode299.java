package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode299 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;

        Map<Character, Integer> secretMap = buildMap(secret);
        Map<Character, Integer> guessMap = buildMap(guess);

        Map<Character, Integer> bullsMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                char c = secret.charAt(i);
                bullsMap.put(c, bullsMap.getOrDefault(c, 0) + 1);
                bulls++;
            }
        }

        for (char c : secretMap.keySet()) {
            int diff = Math.min(secretMap.getOrDefault(c, 0), guessMap.getOrDefault(c, 0)) - bullsMap.getOrDefault(c, 0);
            if (diff > 0) {
                cows += diff;
            }
        }
        return bulls + "A" + cows + "B";
    }

    private Map<Character, Integer> buildMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    @Test
    public void testCase1() {
        LeetCode299 leetCode299 = new LeetCode299();
        assert leetCode299.getHint("1807", "7810").equals("1A3B");
    }

    @Test
    public void testCase2() {
        LeetCode299 leetCode299 = new LeetCode299();
        assert leetCode299.getHint("1123", "0111").equals("1A1B");
    }

    @Test
    public void testCase3() {
        LeetCode299 leetCode299 = new LeetCode299();
        assert leetCode299.getHint("1122", "2211").equals("0A4B");
    }

    @Test
    public void testCase4() {
        LeetCode299 leetCode299 = new LeetCode299();
        assert leetCode299.getHint("1122", "2211").equals("0A4B");
    }
}
