package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode6128 {
    public String bestHand(int[] ranks, char[] suits) {
        // 同花
        if (isAllSameSuit(suits)) {
            return "Flush";
        }
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int rank : ranks) {
            cntMap.put(rank, cntMap.getOrDefault(rank, 0) + 1);
        }
        // 三条
        Set<Integer> set = new HashSet<>(cntMap.values());
        if (set.contains(5) || set.contains(4) || set.contains(3)) {
            return "Three of a Kind";
        }
        // 对子
        if (set.contains(2)) {
            return "Pair";
        }
        // 高牌
        return "High Card";
    }

    private boolean isAllSameSuit(char[] suits) {
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode6128 leetCode6128 = new LeetCode6128();
        String ans = leetCode6128.bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'});
        assert ans.equals("Flush");
    }

    @Test
    public void testCase2() {
        LeetCode6128 leetCode6128 = new LeetCode6128();
        String ans = leetCode6128.bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'});
        assert ans.equals("Three of a Kind");
    }

    @Test
    public void testCase3() {
        LeetCode6128 leetCode6128 = new LeetCode6128();
        String ans = leetCode6128.bestHand(new int[]{10, 10, 2, 12, 9}, new char[]{'a', 'b', 'c', 'a', 'd'});
        assert ans.equals("Pair");
    }
}
