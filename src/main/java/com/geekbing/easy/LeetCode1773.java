package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = 0;
        if ("color".equals(ruleKey)) {
            idx = 1;
        } else if ("name".equals(ruleKey)) {
            idx = 2;
        }
        int ans = 0;
        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(new ArrayList<>(Arrays.asList("phone", "blue", "pixel")));
        items.add(new ArrayList<>(Arrays.asList("computer", "silver", "lenovo")));
        items.add(new ArrayList<>(Arrays.asList("phone", "gold", "iphone")));

        String ruleKey = "color";
        String ruleValue = "silver";

        LeetCode1773 leetCode1773 = new LeetCode1773();
        System.out.println(leetCode1773.countMatches(items, ruleKey, ruleValue));
    }
}
