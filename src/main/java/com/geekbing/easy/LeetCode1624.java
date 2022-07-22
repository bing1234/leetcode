package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Tuple[] buckets = new Tuple[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            Tuple tuple = buckets[idx];
            if (tuple == null) {
                tuple = new Tuple(i, null);
            } else {
                tuple.setEnd(i);
            }
            buckets[idx] = tuple;
        }
        int ans = -1;
        for (Tuple tuple : buckets) {
            if (tuple != null && tuple.getBegin() != null && tuple.getEnd() != null) {
                ans = Math.max(ans, tuple.getEnd() - tuple.getBegin() - 1);
            }
        }
        return ans;
    }

    private static final class Tuple {
        private Integer begin;
        private Integer end;

        public Tuple(Integer begin, Integer end) {
            this.begin = begin;
            this.end = end;
        }

        public Integer getBegin() {
            return begin;
        }

        public void setBegin(Integer begin) {
            this.begin = begin;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }
    }

    public static void main(String[] args) {
        LeetCode1624 leetCode1624 = new LeetCode1624();
        System.out.println(leetCode1624.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(leetCode1624.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(leetCode1624.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(leetCode1624.maxLengthBetweenEqualCharacters("cabbac"));
    }
}
