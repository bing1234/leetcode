package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode421 {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        List<String> strs = new ArrayList<>();
        for (int num : nums) {
            String str = toBinaryString(num);
            strs.add(str);
            trie.insertNum(str);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, trie.search(strs.get(i), nums[i]));
        }
        return max;
    }

    private String toBinaryString(int num) {
        String str = Integer.toBinaryString(num);
        int padding = 32 - str.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            ans.append("0");
        }
        for (int i = 0; i < str.length(); i++) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }

    private static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        private void insertNum(String num) {
            Node cur = root;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (cur.childs[c - '0'] == null) {
                    cur.childs[c - '0'] = new Node();
                }
                cur = cur.childs[c - '0'];
            }
        }

        private int search(String numStr, int num) {
            int other = 0;
            Node cur = root;
            for (int i = 0; i < numStr.length(); i++) {
                char c = numStr.charAt(i);
                if (c == '0') {
                    if (cur.childs[1] != null) {
                        cur = cur.childs[1];
                        other = other * 2 + 1;
                    } else {
                        cur = cur.childs[0];
                        other = other * 2;
                    }
                } else {
                    if (cur.childs[0] != null) {
                        cur = cur.childs[0];
                        other = other * 2;
                    } else {
                        cur = cur.childs[1];
                        other = other * 2 + 1;
                    }
                }
            }
            return num ^ other;
        }
    }

    private static class Node {
        private final Node[] childs;

        public Node() {
            childs = new Node[2];
        }
    }

    @Test
    public void toBinaryStringTest() {
        LeetCode421 leetCode421 = new LeetCode421();
        System.out.println(leetCode421.toBinaryString(1));
        System.out.println(leetCode421.toBinaryString(2));
        System.out.println(leetCode421.toBinaryString(3));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
    }

    @Test
    public void testCase1() {
        LeetCode421 leetCode421 = new LeetCode421();
        int ans = leetCode421.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
        assert ans == 28;
    }

    @Test
    public void testCase2() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{0}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{2, 4}) == 6;
    }

    @Test
    public void testCase4() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{8, 10, 2}) == 10;
    }

    @Test
    public void testCase5() {
        LeetCode421 leetCode421 = new LeetCode421();
        assert leetCode421.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}) == 127;
    }
}
