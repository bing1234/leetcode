package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1408 {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1408 leetCode1408 = new LeetCode1408();
        System.out.println(leetCode1408.stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(leetCode1408.stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"}));
        System.out.println(leetCode1408.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(leetCode1408.stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(leetCode1408.stringMatching(new String[]{"blue", "green", "bu"}));
    }
}
