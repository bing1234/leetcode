package com.geekbing.easy;

/**
 * @author bing
 */
public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for (char c : sentence.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int count : arr) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1832 solution1832 = new Solution1832();
        System.out.println(solution1832.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(solution1832.checkIfPangram("leetcode"));
    }
}
