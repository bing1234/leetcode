package com.geekbing.middle;

import java.util.*;

/**
 * @author bing
 */
public class LeetCode593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int p1p2 = lenSquare(p1, p2);
        int p1p3 = lenSquare(p1, p3);
        int p1p4 = lenSquare(p1, p4);
        int p2p3 = lenSquare(p1, p4);
        int p2p4 = lenSquare(p2, p4);
        int p3p4 = lenSquare(p3, p4);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(p1p2, map.getOrDefault(p1p2, 0) + 1);
        map.put(p1p3, map.getOrDefault(p1p3, 0) + 1);
        map.put(p1p4, map.getOrDefault(p1p4, 0) + 1);
        map.put(p2p3, map.getOrDefault(p2p3, 0) + 1);
        map.put(p2p4, map.getOrDefault(p2p4, 0) + 1);
        map.put(p3p4, map.getOrDefault(p3p4, 0) + 1);

        if (map.size() != 2) {
            return false;
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        int len1 = Math.min(keys.get(0), keys.get(1));
        int len2 = Math.max(keys.get(0), keys.get(1));
        return len1 != 0 && len2 != 0 && map.get(len1) == 4 && map.get(len2) == 2 && len1 * 2 == len2;
    }

    private int lenSquare(int[] p1, int[] p2) {
        int len1 = p1[0] - p2[0];
        int len2 = p1[1] - p2[1];
        return len1 * len1 + len2 * len2;
    }

    public static void main(String[] args) {
        LeetCode593 leetCode593 = new LeetCode593();

//        System.out.println(leetCode593.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println(leetCode593.validSquare(new int[]{0, 0}, new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}));
    }
}
