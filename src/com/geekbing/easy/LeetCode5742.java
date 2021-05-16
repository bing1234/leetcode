package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode5742 {
    public String sortSentence(String s) {
        String[] items = s.split(" ");
        String[] words = new String[items.length];
        for (String item : items) {
            Tuple tuple = getNumFromItem(item);
            words[tuple.index] = tuple.word;
        }
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(word).append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }

    private Tuple getNumFromItem(String item) {
        int idx = 0;
        char[] chars = item.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                idx = i;
                break;
            }
        }
        Tuple tuple = new Tuple();
        tuple.index = Integer.parseInt(item.substring(idx)) - 1;
        tuple.word = item.substring(0, idx);
        return tuple;
    }

    private static final class Tuple {
        private int index;
        private String word;
    }

    public static void main(String[] args) {
        LeetCode5742 leetCode5742 = new LeetCode5742();
        System.out.println(leetCode5742.sortSentence("is2 sentence4 This1 a3"));
        System.out.println(leetCode5742.sortSentence("Myself2 Me1 I4 and3"));
    }
}
