package com.geekbing.middle;

import java.util.*;

public class LeetCode17 {
    private static final Map<String, List<String>> map = new HashMap<>();

    static {
        map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        backtrack(ans, digits.toCharArray(), "", 0);
        return ans;
    }

    private void backtrack(List<String> ans, char[] digits, String cur, int start) {
        if (cur.length() == digits.length) {
            ans.add(cur);
            return;
        }
        for (int i = start; i < digits.length; i++) {
            for (String digit : map.get(String.valueOf(digits[i]))) {
                backtrack(ans, digits, cur + digit, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));
    }
}
