package com.geekbing.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class Interview1620 {
    private static final char[] BUCKET = new char[]{'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(num, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean match(String num, String word) {
        for (int i = 0; i < num.length(); i++) {
            if (BUCKET[word.charAt(i) - 'a'] != num.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interview1620 interview1620 = new Interview1620();

        System.out.println(interview1620.getValidT9Words("8733", new String[]{"tree", "used"}));
        System.out.println(interview1620.getValidT9Words("2", new String[]{"a", "b", "c", "d"}));
    }
}
