package com.geekbing.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> j = new HashSet<>(J.length());
        for (char c : J.toCharArray()) {
            j.add(c);
        }

        int count = 0;
        for (char s : S.toCharArray()) {
            if (j.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStonesV2(String J, String S) {
        int[] j = new int[128];
        for (char c : J.toCharArray()) {
            j[c] = 1;
        }

        int count = 0;
        for (char s : S.toCharArray()) {
            if (j[s] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode771 leetCode771 = new LeetCode771();
        System.out.println(leetCode771.numJewelsInStonesV2("aA", "aAAbbbb"));
        System.out.println(leetCode771.numJewelsInStonesV2("z", "ZZ"));
    }
}
