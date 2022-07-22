package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author bing
 */
public class LeetCode2053 {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Pair> map = buildPairsMap(arr);
        List<Pair> pairs = map.values().stream().filter(p -> p.count == 1).sorted(Comparator.comparingInt(p -> p.idx)).collect(Collectors.toList());
        if (pairs.size() < k) {
            return "";
        }
        return pairs.get(k - 1).str;
    }

    private Map<String, Pair> buildPairsMap(String[] arr) {
        Map<String, Pair> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Pair pair = map.getOrDefault(arr[i], new Pair(arr[i], i, 0));
            pair.count += 1;
            map.put(arr[i], pair);
        }
        return map;
    }

    private static class Pair {
        /**
         * 字符串
         */
        private String str;

        /**
         * 第一次出现的下标
         */
        private int idx;

        /**
         * 一共出现的次数
         */
        private int count;

        public Pair(String str, int idx, int count) {
            this.str = str;
            this.idx = idx;
            this.count = count;
        }
    }

    @Test
    public void testCase1() {
        LeetCode2053 leetCode2053 = new LeetCode2053();
        String ans = leetCode2053.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2);
        assert ans.equals("a");
    }

    @Test
    public void testCase2() {
        LeetCode2053 leetCode2053 = new LeetCode2053();
        String ans = leetCode2053.kthDistinct(new String[]{"aaa", "aa", "a"}, 1);
        assert ans.equals("aaa");
    }

    @Test
    public void testCase3() {
        LeetCode2053 leetCode2053 = new LeetCode2053();
        String ans = leetCode2053.kthDistinct(new String[]{"a", "b", "a"}, 3);
        assert ans.equals("");
    }
}
