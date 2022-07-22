package com.geekbing.easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {
    private static final Map<Character, Integer> MAP = new HashMap<>();

    static {
        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        int ans = 0, pre = 0, cur;
        for (char c : s.toCharArray()) {
            cur = MAP.get(c);
            if (cur > pre) {
                ans = ans + cur - pre - pre;
            } else {
                ans = ans + cur;
            }
            pre = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        System.out.println(leetCode13.romanToInt("III"));
        System.out.println(leetCode13.romanToInt("IV"));
        System.out.println(leetCode13.romanToInt("IX"));
        System.out.println(leetCode13.romanToInt("LVIII"));
        System.out.println(leetCode13.romanToInt("MCMXCIV"));
    }
}
