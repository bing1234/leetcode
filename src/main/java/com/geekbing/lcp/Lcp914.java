package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class Lcp914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> common = null;
        for (Integer key : map.keySet()) {
            if (common == null) {
                common = divisors(map.get(key));
            } else {
                common = intersection(common, divisors(map.get(key)));
            }
            if (common.size() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算Set的交集
     */
    private Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> ans = new HashSet<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                ans.add(num);
            }
        }
        return ans;
    }

    /**
     * 找到所有大于2且能被n整除的数
     */
    private Set<Integer> divisors(int n) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        Lcp914 lcp914 = new Lcp914();
        assert lcp914.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
    }

    @Test
    public void testCase2() {
        Lcp914 lcp914 = new Lcp914();
        assert !lcp914.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3});
    }

    @Test
    public void testCase3() {
        Lcp914 lcp914 = new Lcp914();
        assert !lcp914.hasGroupsSizeX(new int[]{1});
    }

    @Test
    public void testCase4() {
        Lcp914 lcp914 = new Lcp914();
        assert lcp914.hasGroupsSizeX(new int[]{1, 1});
    }

    @Test
    public void testCase5() {
        Lcp914 lcp914 = new Lcp914();
        assert lcp914.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2});
    }
}
