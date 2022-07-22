package com.geekbing.lcp;

import java.util.*;

/**
 * @author bing
 */
public class Lcp07 {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> directMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            directMap.put(i, new LinkedList<>());
        }
        for (int[] item : relation) {
            directMap.get(item[1]).add(item[0]);
        }

        List<Integer> cur = directMap.get(n - 1);
        List<Integer> temp = new ArrayList<>(cur);
        for (int i = 1; i < k; i++) {
            temp = new LinkedList<>();
            for (Integer num : cur) {
                temp.addAll(directMap.get(num));
            }
            cur = temp;
        }
        return (int) temp.stream().filter(num -> num == 0).count();
    }

    public static void main(String[] args) {
        Lcp07 lcp07 = new Lcp07();

        System.out.println(lcp07.numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
        System.out.println(lcp07.numWays(3, new int[][]{{0, 2}, {2, 1}}, 2));
        System.out.println(lcp07.numWays(3, new int[][]{{0, 2}, {0, 1}, {1, 2}, {2, 1}, {2, 0}, {1, 0}}, 1));
    }
}
